---------------------------------------------------------------
-- 1. Lista de profesores con su sueldo, indicando si son o no
-- profesores jefe y alumnos de su jefatura, si corresponde.
---------------------------------------------------------------

SELECT profesor.nombre, profesor.sueldo, profesor_curso.jefatura, alumno.nombre
FROM profesor, profesor_curso, curso, alu_curso, alumno
WHERE profesor.id_profesor = profesor_curso.id_profesor
AND profesor_curso.id_curso = alu_curso.id_curso
AND alu_curso.id_alumno = alumno.id_alumno
GROUP BY profesor.nombre, profesor.sueldo, profesor_curso.jefatura;

---------------------------------------------------------------
-- 2. Lista de alumnos con más inasistencias por mes por curso
-- el 2019.
---------------------------------------------------------------

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