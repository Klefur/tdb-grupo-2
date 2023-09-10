INSERT INTO CURSO (id, nombre)
VALUES
    (1, 'Matematicas'),
    (2, 'Lenguaje'),
    (3, 'Historia');

INSERT INTO PLANTILLA_CURSO (id, evaluaciones, id_curso)
VALUES
    (1, 2, 1),
    (2, 3, 2),
    (3, 3, 3);

INSERT INTO COMUNA (id, nombre)
VALUES
    (1, 'Quilicura'),
    (2, 'Renca'),
    (3, 'Independencia');

INSERT INTO COLEGIO (id, nombre, id_comuna)
VALUES
    (1, 'Colegio 1Q', 1),
    (2, 'Colegio 2R', 2),
    (3, 'Colegio 3I', 3),
    (4, 'Colegio 4I', 3);

INSERT INTO EMPLEADO (id, nombre, sueldo, rol, id_comuna, id_colegio)
VALUES
    (1, 'Empleado 1', 200000, 'Profesor', 1, 1),
    (2, 'Empleado 2', 200000, 'Profesor', 2, 2),
    (3, 'Empleado 3', 200000, 'Profesor', 3, 3),
    (4, 'Empleado 4', 200000, 'Profesor', 3, 3),
    (5, 'Empleado 5', 10000, 'Auxiliar', 2, 2),
    (6, 'Empleado 6', 10000, 'Auxiliar', 3, 3);

INSERT INTO PROFESOR (id, nombre, id_empleado)
VALUES
    (1, 'Profe 1', 1),
    (2, 'Profe 2', 2),
    (3, 'Profe 3', 3),
    (4, 'Profe 4', 4);

INSERT INTO APODERADO (id, nombre, relacion, id_comuna)
VALUES
    (1, 'APODERADO 1', 'Padre', 1),
    (2, 'APODERADO 2', 'Madre', 2),
    (3, 'APODERADO 3', 'Abuelo', 3),
    (4, 'APODERADO 4', 'Padre', 3);

INSERT INTO ALUMNO (id, nombre, id_apoderado, id_comuna, id_colegio)
VALUES
    (1, 'Alumno 1', 1, 1, 1),
    (2, 'Alumno 2', 2, 2, 2),
    (3, 'Alumno 3', 3, 3, 3),
    (4, 'Alumno 4', 4, 3, 3);

INSERT INTO PROF_CURSO (id, id_profesor, id_curso, profesor_jefe)
VALUES
    (1, 1, 1, false),
    (2, 2, 2, false),
    (3, 3, 3, true),
    (4, 4, 3, false);

INSERT INTO ALU_CURSO (id, course_year, id_curso, id_alumno)
VALUES
    (1, 2001, 1, 1),
    (2, 2001, 2, 2),
    (3, 2002, 3, 3),
    (4, 2002, 3, 4);

INSERT INTO FRANJA_HORARIA (id, hora_inicio, hona_fin, presente, dia, id_prof_curso)
VALUES
    (1, '09:30:00', '10:30:00', true, '2023-09-10', 1),
    (2, '09:30:00', '10:30:00', true, '2023-09-10', 2),
    (3, '09:30:00', '10:30:00', true, '2023-09-10', 3),
    (4, '09:30:00', '10:30:00', true, '2023-09-10', 4);

INSERT INTO ASISTENCIA (id, fecha, id_franja, id_alu_curso, presente)
VALUES
    (1, '2023-09-10', 1, 1, true),
    (2, '2023-09-10', 2, 2, true),
    (3, '2023-09-10', 3, 3, true),
    (4, '2023-09-10', 4, 4, true);