-- Database: ColegioDB

--DROP DATABASE IF EXISTS ColegioDB;

-- Por algun motivo no funciona junto con crear tablas
--CREATE DATABASE ColegioDB
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Spanish_Chile.1252'
--    LC_CTYPE = 'Spanish_Chile.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1
--    IS_TEMPLATE = False;
	
create table if not exists CURSO
(id serial primary key,
nombre varchar(50) not null);

create table if not exists PLANTILLA_CURSO
(id serial primary key,
evaluaciones int not null,
id_curso int not null,
constraint fk_curso
	foreign key(id_curso)
		references curso(id));

create table if not exists COMUNA
(id serial primary key,
nombre varchar(100) not null);

create table if not exists COLEGIO
(id serial primary key,
nombre varchar(100) not null,
id_comuna int not null,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id));

create table if not exists EMPLEADO
(id serial primary key,
nombre varchar(100) not null,
sueldo int not null,
rol varchar(45) not null,
id_comuna int not null,
id_colegio int not null,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id),
constraint fk_colegio
	foreign key(id_colegio)
		references colegio(id));

create table if not exists PROFESOR
(id serial primary key,
nombre varchar(100) not null,
id_empleado int not null,
constraint fk_empleado
	foreign key(id_empleado)
		references empleado(id));

create table if not exists APODERADO
(id serial primary key,
nombre varchar(100) not null,
relacion varchar(45) not null,
id_comuna int not null,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id));

create table if not exists ALUMNO
(id serial primary key,
nombre varchar(100) not null,
id_apoderado int not null,
id_comuna int not null,
id_colegio int not null,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id),
constraint fk_apoderado
	foreign key(id_apoderado)
		references apoderado(id),
constraint fk_colegio
	foreign key(id_colegio)
		references colegio(id));

create table if not exists PROF_CURSO 
(id serial primary key,
profesor_jefe bool default false,
id_profesor int not null,
id_curso int not null,
constraint fk_profesor
 	foreign key(id_profesor)
 		references profesor(id),
constraint fk_curso
 	foreign key(id_curso)
 		references curso(id));

create table if not exists ALU_CURSO
(id serial primary key,
course_year smallint not null,
id_curso int not null,
id_alumno int not null,
constraint fk_curso
	foreign key(id_curso)
		references curso(id),
 constraint fk_alumno
	foreign key(id_alumno)
		references alumno(id));

create table if not exists FRANJA_HORARIA
(id serial primary key,
hora_inicio time not null,
hona_fin time not null,
presente bool default false,
dia varchar(45) not null,
id_prof_curso int not null,
constraint fk_prof_curso
 	foreign key(id_prof_curso)
		references prof_curso(id));

create table if not exists ASISTENCIA
(id serial primary key,
fecha date not null,
presente bool default false,
id_franja int not null,
id_alu_curso int not null,
constraint fk_franja
	foreign key(id_franja)
		references franja_horaria(id),
constraint fk_alu_curso
	foreign key(id_alu_curso)
		references alu_curso(id));