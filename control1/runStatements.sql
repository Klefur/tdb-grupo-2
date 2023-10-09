---------------------------------------------------------------
---------------------------------------------------------------
-- 1. Lista de profesores con su sueldo, indicando si son o no
-- profesores jefe y alumnos de su jefatura, si corresponde.
---------------------------------------------------------------

SELECT profesor.nombre AS nombre_profesor,empleado.sueldo,
  CASE WHEN profesor_curso.profesor_jefe = true THEN 'Si' ELSE 'No' END AS es_profesor_jefe,
  curso.nombre AS nombre_curso, 
  (CASE WHEN profesor_curso.profesor_jefe = true
  		THEN ARRAY_AGG(alumno.nombre) 
  		ELSE NULL
  		END)
  AS alumnos_de_jefatura
FROM profesor
INNER JOIN empleado ON empleado.id = profesor.id_empleado 
LEFT JOIN prof_curso AS profesor_curso ON profesor.id = profesor_curso.id_profesor
LEFT JOIN curso ON profesor_curso.id_curso = curso.id
LEFT JOIN alu_curso AS alumno_curso ON curso.id = alumno_curso.id_curso
LEFT JOIN alumno ON alumno_curso.id_alumno = alumno.id
GROUP BY profesor.nombre, empleado.sueldo, profesor_curso.profesor_jefe, curso.nombre;

---------------------------------------------------------------
-- 2. Lista de alumnos con más inasistencias por mes por curso
-- el 2019.
---------------------------------------------------------------
WITH InasistenciasPorAlumno AS (
    SELECT alumno.nombre AS nombre, curso.id AS id_curso, EXTRACT(MONTH FROM asistencia.fecha) AS mes, COUNT(*) AS inasistencias
    FROM alumno
    INNER JOIN alu_curso ON alumno.id = alu_curso.id_alumno
    INNER JOIN curso ON alu_curso.id_curso = curso.id
    INNER JOIN asistencia ON alu_curso.id = asistencia.id_alu_curso
    WHERE asistencia.presente = false AND EXTRACT(YEAR FROM asistencia.fecha) = 2019
    GROUP BY alumno.nombre, curso.id, mes
)

SELECT nombre, mes, id_curso, inasistencias
FROM (
    SELECT nombre, mes, id_curso, ROW_NUMBER() OVER(PARTITION BY mes, id_curso ORDER BY inasistencias DESC) AS ranking, inasistencias
    FROM InasistenciasPorAlumno
) AS ranked
WHERE ranking = 1;

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
GROUP BY curso.id, course_year, nombre
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

SELECT al.nombre, c.nombre
FROM alu_curso AS ac, curso AS c, alumno AS al, asistencia AS ast
WHERE ac.id = ast.id_alu_curso AND ac.id_alumno = al.id AND c.id = ac.id_curso AND ast.presente = true
GROUP BY c.nombre, al.nombre

---------------------------------------------------------------
-- 6. Profesor con más horas de clases y mostrar su sueldo.
-- ( En caso de empate, mostrar el que tenga mayor sueldo )
---------------------------------------------------------------
SELECT
    hp.nombre_profesor,
	hp.horas_clases,
    e.sueldo
FROM (
	SELECT
        p.id AS id_profesor,
        p.nombre AS nombre_profesor,
        ROUND(SUM(EXTRACT(EPOCH FROM (fh.hona_fin - fh.hora_inicio))) / 3600, 2) AS horas_clases
    FROM profesor p
    INNER JOIN prof_curso pc ON p.id = pc.id_profesor
    INNER JOIN franja_horaria fh ON pc.id = fh.id_prof_curso
    GROUP BY p.id, p.nombre) hp
INNER JOIN empleado e ON hp.id_profesor = e.id
ORDER BY
    hp.horas_clases DESC,
	sueldo DESC
LIMIT 1;
---------------------------------------------------------------

---------------------------------------------------------------
-- 7. Profesor con menos horas de clases y mostrar su sueldo.
-- ( En caso de empate, mostrar el que tenga mayor sueldo )
---------------------------------------------------------------
SELECT
    hp.nombre_profesor,
	hp.horas_clases,
    e.sueldo
FROM (
	SELECT
        p.id AS id_profesor,
        p.nombre AS nombre_profesor,
        ROUND(SUM(EXTRACT(EPOCH FROM (fh.hona_fin - fh.hora_inicio))) / 3600, 2) AS horas_clases
    FROM profesor p
    INNER JOIN prof_curso pc ON p.id = pc.id_profesor
    INNER JOIN franja_horaria fh ON pc.id = fh.id_prof_curso
    GROUP BY p.id, p.nombre) hp
INNER JOIN empleado e ON hp.id_profesor = e.id
ORDER BY
    hp.horas_clases ASC,
	sueldo DESC
LIMIT 1;
---------------------------------------------------------------

---------------------------------------------------------------
-- 8. Listado de alumnos por curso donde el apoderado no es su
-- padre o madre.
---------------------------------------------------------------

SELECT ac.nombre AS Nombre_Alumno ,ac.id_curso AS ID_Curso , no_mp.relacion AS Relacion  
FROM  (SELECT a.id_apoderado ,a.nombre,alu_curso.id_curso
		FROM alumno AS a
		INNER JOIN alu_curso ON alu_curso.id_alumno = a.id
		GROUP BY (a.id_apoderado,alu_curso.id_curso,a.nombre)) AS ac ,
		
		(SELECT *
		FROM apoderado AS ap
		WHERE lower(ap.relacion) not like '%padre%' and lower(ap.relacion) not like '%madre%' ) AS no_mp
		
WHERE ac.id_apoderado = no_mp.id 
GROUP BY ac.id_curso,ac.nombre,no_mp.relacion


---------------------------------------------------------------
-- 9. Colegio con mayor promedio de asistencia el año 2019,
-- identificando la comuna.
---------------------------------------------------------------

SELECT col_asis.nombre AS nombre_colegio,comuna.nombre AS nombre_comuna,AVG(col_asis.contador) AS promedio_maximo
FROM (
    SELECT colegio.nombre,alu_curso.id_curso,comuna.id,COUNT(alu_curso.id_curso) AS contador
    FROM asistencia
    INNER JOIN alu_curso ON asistencia.id_alu_curso = alu_curso.id
    INNER JOIN alumno ON alu_curso.id_alumno = alumno.id
    INNER JOIN colegio ON colegio.id = alumno.id_colegio
    INNER JOIN comuna ON colegio.id_comuna = comuna.id
    WHERE EXTRACT(YEAR FROM fecha) = 2019 AND asistencia.presente = 'true'
    GROUP BY colegio.nombre, alu_curso.id_curso, comuna.id ) AS col_asis
INNER JOIN comuna ON col_asis.id = comuna.id
GROUP BY col_asis.nombre, col_asis.id, comuna.nombre
ORDER BY promedio_maximo DESC
LIMIT 1;

---------------------------------------------------------------
-- 10. Listado de colegios con mayor número de alumnos por año.
---------------------------------------------------------------

WITH infocolegios AS (
	SELECT c.nombre AS nombre, ac.course_year AS anio, COUNT(a.id_colegio) AS cantidad_alumnos,
		RANK() OVER (PARTITION BY ac.course_year ORDER BY COUNT(a.id_colegio) DESC) AS ranking
	FROM alu_curso AS ac, alumno a, colegio c
	WHERE ac.id_alumno = a.id AND a.id_colegio = c.id
	GROUP BY c.nombre, ac.course_year
)

SELECT nombre, anio, cantidad_alumnos
FROM infocolegios
WHERE ranking = 1;
