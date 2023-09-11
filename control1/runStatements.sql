---------------------------------------------------------------
-- 1. Lista de profesores con su sueldo, indicando si son o no
-- profesores jefe y alumnos de su jefatura, si corresponde.
---------------------------------------------------------------

SELECT profesor.nombre, profesor.sueldo, profesor_curso.jefatura, curso.nombre, alumnos
CASE WHEN profesor_curso.jefatura = 1 THEN 'Si' ELSE 'No' END AS jefatura,
CASE WHEN profesor_curso.jefatura = 1 THEN ARRAY_AGG(alumno.nombre) ELSE NULL END AS alumnos
FROM public."Profesor" AS profesor
LEFT JOIN "ProfesorCurso" AS profesor_curso ON profesor.id_profesor = profesor_curso.id_profesor
LEFT JOIN "Curso" AS curso ON profesor_curso.id_curso = curso.id_curso
LEFT JOIN "AlumnoCurso" AS alumno_curso ON curso.id_curso = alumno_curso.id_curso
LEFT JOIN "Alumno" AS alumno ON alumno_curso.id_alumno = alumno.id_alumno
GROUP BY (profesor.nombre, profesor.sueldo, profesor_curso.jefatura);

---------------------------------------------------------------
-- 2. Lista de alumnos con más inasistencias por mes por curso
-- el 2019.
---------------------------------------------------------------

SELECT alumno.nombre
FROM 
(SELECT alumno.nombre AS nombre, 
EXTRACT(MONTH FROM asistencia.fecha_asistencia) AS mes,
EXTRACT(YEAR FROM aistencia.fecha_asistencia) AS anio,
COUNT(alumno.nombre) AS inasistencias
FROM public."Alumno" AS alu
INNER JOIN "AlumnoCurso" AS alu_curso ON alu.id_alumno = alu_curso.id_alumno
INNER JOIN "Curso" AS curso ON alu_curso.id_curso = curso.id_curso
INNER JOIN "Asistencia" AS asistencia ON alu.id_alumno = asistencia.id_alumno
WHERE asistencia.presente = 0 AND mes = 2019
GROUP BY (alu.nombre, mes, anio)) AS alumnos
WHERE alumnos.inasistencias = (SELECT MAX(inasistencias) FROM alumnos);


---------------------------------------------------------------
-- 3. Lista de empleados identificando su rol, sueldo y comuna
-- de residencia. Debe estar ordenada por comuna y sueldo.
---------------------------------------------------------------

---------------------------------------------------------------
-- 4. Curso con menos alumnos por año.
---------------------------------------------------------------

---------------------------------------------------------------
-- 5. Identificar al alumno que no ha faltado nunca por curso.
---------------------------------------------------------------

---------------------------------------------------------------

---------------------------------------------------------------
-- 6. Profesor con más horas de clases y mostrar su sueldo.
---------------------------------------------------------------

---------------------------------------------------------------

---------------------------------------------------------------
-- 7. Profesor con menos horas de clases y mostrar su sueldo.
---------------------------------------------------------------

---------------------------------------------------------------

---------------------------------------------------------------
-- 8. Listado de alumnos por curso donde el apoderado no es su
-- padre o madre.
---------------------------------------------------------------

---------------------------------------------------------------
-- 9. Colegio con mayor promedio de asistencia el año 2019,
-- identificando la comuna.
---------------------------------------------------------------

---------------------------------------------------------------
-- 10. Listado de colegios con mayor número de alumnos por año.
---------------------------------------------------------------
