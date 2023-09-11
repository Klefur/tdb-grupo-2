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
SELECT emp.rol, emp.sueldo, comuna.nombre
FROM empleado as emp
INNER JOIN comuna ON emp.id_comuna = comuna.id
ORDER BY comuna.nombre, emp.sueldo
---------------------------------------------------------------
-- 4. Curso con menos alumnos por año.
---------------------------------------------------------------
SELECT curso.id, course_year, nombre, COUNT(id_alumno) AS cantidad_alumnos
FROM alu_curso
JOIN curso ON alu_curso.id_curso = curso.id
GROUP BY course.id, course_year, nombre
HAVING COUNT(id_alumno) = (
  SELECT MIN(contador_alumnos)
  FROM (
    SELECT course_year, COUNT(id_alumno) AS contador_alumnos
    FROM alu_curso
    GROUP BY course_year, id_curso
  ) AS subconsulta
  WHERE alu_curso.course_year = subconsulta.course_year
)
ORDER BY course_year;
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

SELECT ac.nombre AS Nombre_Alumno ,ac.id_curso AS ID_Curso , no_mp.relacion AS Relacion  
FROM  (SELECT a.id_apoderado ,a.nombre,alu_curso.id_curso
		FROM alumno AS a
		INNER JOIN alu_curso on alu_curso.id_alumno = a.id
		GROUP BY (a.id_apoderado,alu_curso.id_curso,a.nombre)) AS ac ,
		
		(SELECT *
		FROM apoderado AS ap
		WHERE lower(ap.relacion) not like '%padre%' and lower(ap.relacion) not like '%madre%' ) AS no_mp
		
WHERE ac.id_apoderado = no_mp.id 

---------------------------------------------------------------
-- 9. Colegio con mayor promedio de asistencia el año 2019,
-- identificando la comuna.
---------------------------------------------------------------

SELECT nombre_colegio, comuna, MAX(promedio_asistencia) AS maximo_promedio
FROM (
    SELECT col.nombre AS nombre_colegio, com.nombre AS comuna, AVG(a.presente::int) AS promedio_asistencia
    FROM asistencia AS a
    INNER JOIN alu_curso AS a_c ON a.id_alu_curso = a_c.id
    INNER JOIN alumno AS al ON a_c.id_alumno = al.id
    INNER JOIN colegio AS col ON al.id_colegio = col.id
    INNER JOIN comuna AS com ON com.id = col.id_comuna
    WHERE EXTRACT(YEAR FROM a.fecha) = 2023 AND a.presente = 'true'
    GROUP BY col.nombre, com.nombre) AS PromediosColegios
	
GROUP BY nombre_colegio, comuna
LIMIT 1;

---------------------------------------------------------------
-- 10. Listado de colegios con mayor número de alumnos por año.
---------------------------------------------------------------
