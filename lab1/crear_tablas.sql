create table if not exists ranking
(id serial primary key);

create table if not exists institucion
(id serial primary key,
nombre varchar(50));

create table if not exists voluntario
(id serial primary key,
nombre varchar(50));

create table if not exists tarea
(id serial primary key,
nombre varchar(50));

create table if not exists estado_tarea
(id serial primary key,
nombre varchar(50));

create table if not exists tarea_habilidad
(id serial primary key,
nombre varchar(50));

create table if not exists eme_habilidad
(id serial primary key,
nombre varchar(50));

create table if not exists habilidad
(id serial primary key,
nombre varchar(50));

create table if not exists emergencia
(id serial primary key,
nombre varchar(50));

create table if not exists val_habilidad
(id serial primary key,
nombre varchar(50));