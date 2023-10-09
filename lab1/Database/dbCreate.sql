----------------------------------------
-- Crear base de datos VoluntariadoDB --
----------------------------------------

DROP DATABASE IF EXISTS VoluntariadoDB;

CREATE DATABASE VoluntariadoDB
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    IS_TEMPLATE = false;

----------------------------------------
-- Tabla de Voluntario --
----------------------------------------

CREATE TABLE IF NOT EXISTS Voluntary (
    "id_voluntary" SERIAL NOT NULL PRIMARY KEY,
    "rut" VARCHAR(10) NOT NULL,
    "fullname" VARCHAR(50) NOT NULL,
    "birthday" DATE NOT NULL,
    "state" int NOT NULL,
    "email" VARCHAR(50) NOT NULL,
    "password" VARCHAR(50) NOT NULL
);

----------------------------------------
-- Tabla de Habilidad --
----------------------------------------

CREATE TABLE IF NOT EXISTS Ability(
    "id_ability" SERIAL NOT NULL PRIMARY KEY,
    "names" VARCHAR(50) NOT NULL,
    "items" VARCHAR(50) NOT NULL,
    "description" VARCHAR(100) NOT NULL
);

----------------------------------------
-- Tabla de Voluntario_Habilidad --
----------------------------------------

CREATE TABLE IF NOT EXISTS Voluntary_Ability(
    "id_voluntary_ability" SERIAL NOT NULL PRIMARY KEY,
    "id_voluntary" int,
    "id_ability" int,
    FOREIGN KEY ("id_voluntary") REFERENCES Voluntary ("id_voluntary") ON DELETE CASCADE,
    FOREIGN KEY ("id_ability") REFERENCES Ability ("id_ability") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Institucion --
----------------------------------------

CREATE TABLE IF NOT EXISTS Institution(
    "id_institution" SERIAL NOT NULL PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    "coordinator_name" VARCHAR(50) NOT NULL,
    "email" VARCHAR(50) NOT NULL,
    "password" VARCHAR(50) NOT NULL
);

----------------------------------------
-- Tabla de Emergencia --
----------------------------------------

CREATE TABLE IF NOT EXISTS Emergency(
    "id_emergency" SERIAL NOT NULL PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(100) NOT NULL,
    "state" int NOT NULL,
    "id_institution" int,
    FOREIGN KEY ("id_institution") REFERENCES Institution ("id_institution") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Emergencia_Habilidad --
----------------------------------------

CREATE TABLE IF NOT EXISTS Emergency_Ability(
    "id_emergency_ability" SERIAL NOT NULL PRIMARY KEY,
    "id_emergency" int,
    "id_ability" int,
    FOREIGN KEY ("id_emergency") REFERENCES Emergency ("id_emergency") ON DELETE CASCADE,
    FOREIGN KEY ("id_ability") REFERENCES Ability ("id_ability") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Tarea --
----------------------------------------

CREATE TABLE IF NOT EXISTS Task(
    "id_task" SERIAL NOT NULL PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(100) NOT NULL,
    "state" int NOT NULL,
    "id_institution" int,
    FOREIGN KEY ("id_institution") REFERENCES Institution ("id_institution") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Tarea_Habilidad --
----------------------------------------

CREATE TABLE IF NOT EXISTS Task_Ability(
    "id_task_ability" SERIAL NOT NULL PRIMARY KEY,
    "id_task" int,
    "id_ability" int,
    FOREIGN KEY ("id_task") REFERENCES Task ("id_task") ON DELETE CASCADE,
    FOREIGN KEY ("id_ability") REFERENCES Ability ("id_ability") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Ranking --
----------------------------------------

CREATE TABLE IF NOT EXISTS Ranking(
    "id_ranking" SERIAL NOT NULL PRIMARY KEY,
    "id_task" int,
    "id_voluntary" int,
    FOREIGN KEY ("id_task") REFERENCES Task ("id_task") ON DELETE CASCADE,
    FOREIGN KEY ("id_voluntary") REFERENCES Voluntary ("id_voluntary") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Login_Action --
----------------------------------------
CREATE TABLE IF NOT EXISTS Login_Action(
    "id_login_action" SERIAL NOT NULL PRIMARY KEY,
    "user_name" VARCHAR(50) NOT NULL,
    "action_type" VARCHAR(10) NOT NULL,
    "date_action" TIMESTAMP WITH TIME ZONE,
);

----------------------------------------
-- Triggers --
----------------------------------------
-- 1. Crear trigger que almacene las 
--    queries de inserción, actualización 
--    y eliminación realizadas por el 
--    backend de su aplicación con la 
--    respectiva información de usuario,
--    tiempo de llamada, etc.
----------------------------------------
CREATE FUNCTION log_backend_queries()
RETURNS TRIGGER AS 
$$
DECLARE user_name TEXT;
BEGIN
    SELECT current_user INTO user_name;
    INSERT INTO Login_Action(user_name, id_action, date_action)
    VALUES (user_name, TG_OP, CURRENT_TIMESTAMP);
    RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER trg_log_emergency
AFTER INSERT OR UPDATE OR DELETE
on public."Emergency"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_voluntary
AFTER INSERT OR UPDATE OR DELETE
on public."Voluntary"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_institution
AFTER INSERT OR UPDATE OR DELETE
on public."Institution"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_task
AFTER INSERT OR UPDATE OR DELETE
on public."Task"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_voluntary_ability
AFTER INSERT OR UPDATE OR DELETE
on public."Voluntary_Ability"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_emergency_ability
AFTER INSERT OR UPDATE OR DELETE
on public."Emergency_Ability"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_task_ability
AFTER INSERT OR UPDATE OR DELETE
on public."Task_Ability"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_ranking
AFTER INSERT OR UPDATE OR DELETE
on public."Ranking"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

CREATE TRIGGER trg_log_login_action
AFTER INSERT OR UPDATE OR DELETE
on public."Login_Action"
FOR EACH ROW
EXECUTE PROCEDURE log_backend_queries();

----------------------------------------
-- 2. Crear procedimiento almacenado que
--    entregue un reporte con los
--    usuarios que más queries de 
--    inserción, actualización o 
--    eliminación ejecutan con las
--    respectivas consultas.
----------------------------------------
CREATE TEMP TABLE temp_query_report AS
SELECT 
    current_user AS user_name,
    current_query AS query,
    CASE 
        WHEN current_query LIKE 'INSERT%' THEN 'INSERT'
        WHEN current_query LIKE 'UPDATE%' THEN 'UPDATE'
        WHEN current_query LIKE 'DELETE%' THEN 'DELETE'
    END AS action
FROM pg_stat_statements
WHERE current_query IS NOT NULL;

CREATE FUNCTION generate_report_user_queries()
RETURNS TABLE (user_name TEXT, action_type TEXT, query TEXT, query_count INT) AS
$$
BEGIN
    RETURN QUERY
    SELECT 
        user_name,
        action_type,
        query,
        date_action
        COUNT(*) AS query_count
    FROM temp_query_report
    GROUP BY user_name, action_type, query
    ORDER BY query_count DESC;

END;
$$
LANGUAGE 'plpgsql';

SELECT * FROM generate_report_user_queries();

----------------------------------------
-- 3. Activar o desactivar emergencia.
----------------------------------------
CREATE FUNCTION toggleEmergencyState(id_emergency INT, new_state INT)
RETURNS VOID AS
$$
BEGIN
    UPDATE Emergency
    SET state = new_state
    WHERE id_emergency = id_emergency
END;
$$
LANGUAGE 'plpgsql';

----------------------------------------
-- 4. Contar el total de tareas activas en
--    una emergencia.
----------------------------------------
CREATE FUNCTION countActiveTasksByEmergencyId(id_emergency INT)
RETURNS INT AS
$$
BEGIN
    DECLARE active_tasks INT;

    SELECT COUNT(*) INTO active_tasks
    FROM Task
    WHERE id_emergency = id_emergency AND state = 1;
    RETURN active_tasks;
END;
$$
LANGUAGE 'plpgsql';

----------------------------------------
-- 5. Generar función que calcule el ranking
--    de los voluntarios según con los
--    requisitos que cumple por tarea.
----------------------------------------
