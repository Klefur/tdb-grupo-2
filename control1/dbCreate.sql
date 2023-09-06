drop table if exists ALU_CURSO cascade;
drop table if exists ALUMNO cascade;
drop table if exists APODERADO cascade;
drop table if exists ASISTENCIA cascade;
drop table if exists COLEGIO cascade;
drop table if exists COMUNA cascade;
drop table if exists CURSO cascade;
drop table if exists FRANJA_HORARIA cascade;
drop table if exists PLANTILLA_CURSO cascade;
drop table if exists PROF_CURSO cascade;
drop table if exists PROFESOR cascade;
drop table if exists SUELDO cascade;

create table if not exists SUELDO
(id serial primary key,
cantidad int);

create table if not exists COMUNA
(id serial primary key,
nombre varchar(50));

create table if not exists COLEGIO
(id serial primary key,
nombre varchar(50),
id_comuna int,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id));

create table if not exists PROFESOR
(id serial primary key,
nombre varchar(50),
id_colegio int,
id_sueldo int,
constraint fk_colegio
	foreign key(id_colegio)
		references colegio(id),
constraint fk_sueldo
 	foreign key(id_sueldo)
		references sueldo(id));

create table if not exists CURSO
(id serial primary key,
nombre varchar(50));

create table if not exists APODERADO
(id serial primary key,
nombre varchar(50),
id_comuna int,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id));

create table if not exists ALUMNO
(id serial primary key,
nombre varchar(50),
id_apoderado int,
id_comuna int,
constraint fk_comuna
	foreign key(id_comuna)
		references comuna(id),
constraint fk_apoderado
	foreign key(id_apoderado)
		references apoderado(id));

create table if not exists ASISTENCIA
(id serial primary key,
nombre varchar(50));

create table if not exists FRANJA_HORARIA
(id serial primary key,
nombre varchar(50));

create table if not exists PROF_CURSO 
(flg_profesor_jefe bool default false,
id_profesor int,
id_curso int,
constraint fk_profesor
 	foreign key(id_profesor)
 		references profesor(id),
constraint fk_curso
 	foreign key(id_curso)
 		references curso(id));

create table if not exists CURSO
(id serial primary key,
nombre varchar(50));

create table if not exists ALU_CURSO
(id_curso int,
id_alumno int,
constraint fk_curso
	foreign key(id_curso)
		references curso(id),
 constraint fk_alumno
	foreign key(id_alumno)
		references alumno(id));

create table if not exists PLANTILLA_CURSO
(id serial primary key)