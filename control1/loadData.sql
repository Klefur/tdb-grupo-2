INSERT INTO CURSO (id, nombre)
VALUES
    (1, 'Matematicas'),
    (2, 'Lenguaje'),
    (3, 'Historia'),
    (4, 'Ciencias Naturales'),
    (5, 'Educación Física'),
    (6, 'Arte');

INSERT INTO PLANTILLA_CURSO (id, evaluaciones, id_curso)
VALUES
    (1, 2, 1),
    (2, 3, 2),
    (3, 3, 3),
    (4, 2, 4),
    (5, 3, 5),
    (6, 3, 6);

INSERT INTO COMUNA (id, nombre)
VALUES
    (1, 'Quilicura'),
    (2, 'Renca'),
    (3, 'Independencia'),
    (4, 'Santiago'),
    (5, 'Providencia'),
    (6, 'Las Condes');

INSERT INTO COLEGIO (id, nombre, id_comuna)
VALUES
    (1, 'Colegio 1Q', 1),
    (2, 'Colegio 2R', 2),
    (3, 'Colegio 3I', 3),
    (4, 'Colegio 4I', 3),
    (5, 'Colegio 5S', 4),
    (6, 'Colegio 6P', 5),
    (7, 'Colegio 7L', 6);

INSERT INTO EMPLEADO (id, nombre, sueldo, rol, id_comuna, id_colegio)
VALUES
    (1, 'Empleado 1', 200000, 'Profesor', 1, 1),
    (2, 'Empleado 2', 200000, 'Profesor', 2, 2),
    (3, 'Empleado 3', 200000, 'Profesor', 3, 3),
    (4, 'Empleado 4', 200000, 'Profesor', 3, 3),
    (5, 'Empleado 5', 10000, 'Auxiliar', 2, 2),
    (6, 'Empleado 6', 10000, 'Auxiliar', 3, 3),
     (7, 'Empleado 7', 200000, 'Profesor', 4, 5),
    (8, 'Empleado 8', 200000, 'Profesor', 5, 6),
    (9, 'Empleado 9', 200000, 'Profesor', 6, 7),
    (10, 'Empleado 10', 200000, 'Profesor', 6, 7),
    (11, 'Empleado 11', 10000, 'Auxiliar', 5, 6),
    (12, 'Empleado 12', 10000, 'Auxiliar', 6, 7);


INSERT INTO PROFESOR (id, nombre, id_empleado)
VALUES
    (1, 'Profe 1', 1),
    (2, 'Profe 2', 2),
    (3, 'Profe 3', 3),
    (4, 'Profe 4', 4),
     (5, 'Profe 5', 7),
    (6, 'Profe 6', 8),
    (7, 'Profe 7', 9),
    (8, 'Profe 8', 10);

INSERT INTO APODERADO (id, nombre, relacion, id_comuna)
VALUES
    (1, 'APODERADO 1', 'Padre', 1),
    (2, 'APODERADO 2', 'Madre', 2),
    (3, 'APODERADO 3', 'Abuelo', 3),
    (4, 'APODERADO 4', 'Padre', 3),
     (5, 'APODERADO 5', 'Padre', 4),
    (6, 'APODERADO 6', 'Madre', 5),
    (7, 'APODERADO 7', 'Abuelo', 6),
    (8, 'APODERADO 8', 'Padre', 6);

INSERT INTO ALUMNO (id, nombre, id_apoderado, id_comuna, id_colegio)
VALUES
    (1, 'Alumno 1', 1, 1, 1),
    (2, 'Alumno 2', 2, 2, 2),
    (3, 'Alumno 3', 3, 3, 3),
    (4, 'Alumno 4', 4, 3, 3),
    (5, 'Alumno 5', 5, 4, 5),
    (6, 'Alumno 6', 6, 5, 6),
    (7, 'Alumno 7', 7, 6, 7),
    (8, 'Alumno 8', 8, 6, 7);

INSERT INTO PROF_CURSO (id, id_profesor, id_curso, profesor_jefe)
VALUES
    (1, 1, 1, false),
    (2, 2, 2, false),
    (3, 3, 3, true),
    (4, 4, 3, false),
    (5, 5, 4, false),
    (6, 6, 5, false),
    (7, 7, 6, true),
    (8, 8, 6, false);

INSERT INTO ALU_CURSO (id, course_year, id_curso, id_alumno)
VALUES
    (1, 2001, 1, 1),
    (2, 2001, 2, 2),
    (3, 2002, 3, 3),
    (4, 2002, 3, 4),
    (5, 2001, 1, 2),
    (6, 2002, 3, 2),
     (7, 2001, 1, 3),
    (8, 2002, 3, 5),
    (9, 2002, 3, 6),
    (10, 2001, 1, 4),
    (11, 2002, 3, 7),
    (12, 2002, 3, 8);

INSERT INTO FRANJA_HORARIA (id, hora_inicio, hona_fin, presente, dia, id_prof_curso)
VALUES
    (1, '09:30:00', '10:30:00', true, '2023-09-10', 1),
    (2, '09:30:00', '10:30:00', true, '2023-09-10', 2),
    (3, '09:30:00', '10:30:00', true, '2023-09-10', 3),
    (4, '09:30:00', '10:30:00', true, '2023-09-10', 4),
    (5, '10:30:00', '11:30:00', true, '2023-09-11', 5),
    (6, '10:30:00', '11:30:00', true, '2023-09-11', 6),
    (7, '10:30:00', '11:30:00', true, '2023-09-11', 7),
    (8, '10:30:00', '11:30:00', true, '2023-09-11', 8);

INSERT INTO ASISTENCIA (id, fecha, id_franja, id_alu_curso, presente)
VALUES
    (1, '2019-09-10', 1, 1, true),
    (2, '2019-09-10', 2, 2, true),
    (3, '2019-09-10', 3, 3, true),
    (4, '2019-09-10', 4, 4, true),
    (5, '2019-09-10', 1, 4, false),
    (6, '2019-09-10', 2, 4, false),
    (7, '2019-09-10', 3, 4, false),
    (8, '2019-09-10', 4, 4, false),
    (9, '2019-10-10', 1, 4, false),
    (10, '2019-10-10', 2, 4, false),
    (11, '2019-10-10', 3, 4, false),
    (12, '2019-10-10', 4, 4, false),
     (13, '2019-10-10', 1, 3, true),
    (14, '2019-10-10', 2, 5, true),
    (15, '2019-10-10', 3, 6, true),
    (16, '2019-10-10', 4, 7, true),
    (17, '2019-10-10', 1, 8, false),
    (18, '2019-10-10', 2, 8, false),
    (19, '2019-10-10', 3, 8, false),
    (20, '2019-10-10', 4, 8, false);
