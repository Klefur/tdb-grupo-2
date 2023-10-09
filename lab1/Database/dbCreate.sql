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
    "state" BOOLEAN NOT NULL,
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
    "date" DATE NOT NULL,
    "state" BOOLEAN NOT NULL,
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
    "date" DATE NOT NULL,
    "state" BOOLEAN NOT NULL,
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
    "id_action" int,
    "state" VARCHAR(50),
    "date_action" TIMESTAMP WITH TIME ZONE,
);

----------------------------------------
-- Triggers --
----------------------------------------

