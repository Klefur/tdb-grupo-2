----------------------------------------
-- Crear base de datos VoluntariadoDB --
----------------------------------------

-- DROP DATABASE IF EXISTS VoluntariadoDB;

-- CREATE DATABASE VoluntariadoDB
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Spanish_Spain.1252'
--    LC_CTYPE = 'Spanish_Spain.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;
--    IS_TEMPLATE = false;

CREATE EXTENSION postgis;

----------------------------------------
-- Tabla de User --
----------------------------------------
CREATE TABLE IF NOT EXISTS UserV(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

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
    "password" VARCHAR(50) NOT NULL,
	"latitude" FLOAT,
	"longitude" FLOAT,
    "geom" geometry(Point, 4326)
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
	"latitude" FLOAT,
	"longitude" FLOAT,
    "geom" geometry(Point, 4326),
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
    "id_emergency" int,
    FOREIGN KEY ("id_emergency") REFERENCES Emergency ("id_emergency") ON DELETE CASCADE
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
    "matched_abilities_count" int,
    FOREIGN KEY ("id_task") REFERENCES Task ("id_task") ON DELETE CASCADE,
    FOREIGN KEY ("id_voluntary") REFERENCES Voluntary ("id_voluntary") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Emergency_Voluntary --
----------------------------------------

CREATE TABLE IF NOT EXISTS Emergency_Voluntary(
    "id_emergency_voluntary" SERIAL NOT NULL PRIMARY KEY,
    "id_emergency" int,
    "id_voluntary" int,
    FOREIGN KEY ("id_emergency") REFERENCES Emergency ("id_emergency") ON DELETE CASCADE,
    FOREIGN KEY ("id_voluntary") REFERENCES Voluntary ("id_voluntary") ON DELETE CASCADE
);

----------------------------------------
-- Tabla de Login_Action --
----------------------------------------
CREATE TABLE IF NOT EXISTS Login_Action(
    "id_login_action" SERIAL NOT NULL PRIMARY KEY,
    "id_action" INT,
    "state" INT NOT NULL,
    "date_action" TIMESTAMP WITH TIME ZONE
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


---------------- EMERGENCY ----------------
DROP TRIGGER IF EXISTS trg_emergency_login_action ON Emergency;

-- Función genérica para inserción, actualización y eliminación
CREATE OR REPLACE FUNCTION log_emergency_login_action()
RETURNS TRIGGER AS 
$$
BEGIN
    INSERT INTO Login_Action (id_action, state, date_action) VALUES
    (COALESCE(NEW.id_emergency, OLD.id_emergency),
     COALESCE(NEW.state, OLD.state),
     CURRENT_TIMESTAMP);
    RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

-- Trigger para inserción, actualización y eliminación
CREATE TRIGGER trg_emergency_login_action
AFTER INSERT OR UPDATE OR DELETE ON Emergency
FOR EACH ROW
EXECUTE PROCEDURE log_emergency_login_action();

---------------- VOLUNTARY ----------------
DROP TRIGGER IF EXISTS trg_voluntary_login_action ON Voluntary;

-- Función genérica para inserción, actualización y eliminación
CREATE OR REPLACE FUNCTION log_voluntary_login_action()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO Login_Action (id_action, state, date_action) VALUES
    (COALESCE(NEW.id_voluntary, OLD.id_voluntary),
     COALESCE(NEW.state, OLD.state),
     CURRENT_TIMESTAMP);
    RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

-- Trigger para inserción, actualización y eliminación
CREATE TRIGGER trg_voluntary_login_action
AFTER INSERT OR UPDATE OR DELETE ON Voluntary
FOR EACH ROW
EXECUTE PROCEDURE log_voluntary_login_action();

--------------- TASK ------------------
DROP TRIGGER IF EXISTS trg_task_login_action ON Task;

-- Función genérica para inserción, actualización y eliminación
CREATE OR REPLACE FUNCTION log_task_login_action()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO Login_Action (id_action, state, date_action) VALUES
    (COALESCE(NEW.id_task, OLD.id_task),
     COALESCE(NEW.state, OLD.state),
     CURRENT_TIMESTAMP);
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger para inserción, actualización y eliminación
CREATE TRIGGER trg_task_login_action
AFTER INSERT OR UPDATE OR DELETE ON Task
FOR EACH ROW
EXECUTE PROCEDURE log_task_login_action();


----------------------------------------
-- 2. Crear procedimiento almacenado que
--    entregue un reporte con los
--    usuarios que más queries de 
--    inserción, actualización o 
--    eliminación ejecutan con las
--    respectivas consultas.
----------------------------------------

CREATE TABLE IF NOT EXISTS user_queries (
    user_name_a TEXT,
    action_type_a TEXT,
    query TEXT,
    date_action TIMESTAMP DEFAULT NOW()
);

-- Crear función para registrar consultas de usuario
CREATE OR REPLACE FUNCTION log_user_query(user_name_a TEXT, query TEXT) 
RETURNS VOID AS 
$$
BEGIN
    INSERT INTO user_queries (user_name_a, action_type_a, query)
    VALUES (user_name_a,
            CASE 
                WHEN query LIKE 'INSERT%' THEN 'INSERT'
                WHEN query LIKE 'UPDATE%' THEN 'UPDATE'
                WHEN query LIKE 'DELETE%' THEN 'DELETE'
                ELSE 'OTHER'
            END,
            query);
END;
$$
LANGUAGE plpgsql;


-- Crear función para generar el informe de consultas de usuario
CREATE OR REPLACE FUNCTION generate_report_user_queries()
RETURNS TABLE (user_name_a TEXT, action_type_a TEXT, 
               query TEXT, query_count INT) 
AS 
$$
BEGIN
    RETURN QUERY
    SELECT 
        user_name_a,
        action_type_a,
        query,
        COUNT(*) AS query_count
    FROM user_queries
    WHERE query IS NOT NULL
    GROUP BY user_name_a, action_type_a, query
    ORDER BY query_count DESC;
END;
$$
LANGUAGE plpgsql;


----------------------------------------
-- 3. Activar o desactivar emergencia.
----------------------------------------
CREATE OR REPLACE FUNCTION toggleEmergencyState(p_id_emergency INT, p_new_state INT)
RETURNS VOID AS
$$
BEGIN
    UPDATE Emergency
    SET state = p_new_state
    WHERE id_emergency = p_id_emergency;
END;
$$
LANGUAGE plpgsql;

----------------------------------------
-- 4. Contar el total de tareas activas en
--    una emergencia.
----------------------------------------
CREATE OR REPLACE FUNCTION countActiveTasksByEmergencyId(id_emergency INT)
RETURNS INT AS
$$
DECLARE 
	active_tasks INT;
BEGIN
    SELECT COUNT(*) INTO active_tasks
    FROM Task
    WHERE id_emergency = id_emergency AND state = 1;
    RETURN active_tasks;
END;
$$
LANGUAGE plpgsql;

----------------------------------------
-- 5. Generar función que calcule el ranking
--    de los voluntarios según con los
--    requisitos que cumple por tarea.
----------------------------------------

----------------------------------------
-- Trigger que actualiza el geom 
-- de la emergencia y voluntario
----------------------------------------

CREATE OR REPLACE FUNCTION updateEmergencyGeom() RETURNS trigger AS $$
BEGIN
    UPDATE emergency SET geom = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
  
CREATE TRIGGER updateGeomE
  AFTER INSERT ON emergency
  EXECUTE PROCEDURE updateEmergencyGeom();

CREATE OR REPLACE FUNCTION updateVoluntaryGeom() RETURNS trigger AS $$
BEGIN
    UPDATE voluntary SET geom = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER updateGeomV
  AFTER INSERT ON voluntary
  EXECUTE PROCEDURE updateVoluntaryGeom();
