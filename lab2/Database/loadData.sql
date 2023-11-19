------------------------------------------
-- 1. Tabla Voluntary: 10 registros
------------------------------------------
INSERT INTO Voluntary (rut, fullname, birthday, state, email, password, latitude, longitude) VALUES
('20000001-2', 'Juan Pérez', '1988-04-15', 1, 'juanperez@example.com', 'pass5678', -33.0451, -71.6198),
('20000002-3', 'Ana Gómez', '1990-06-20', 1, 'anagomez@example.com', 'pass9012', -36.8201, -73.0444),
('20000003-4', 'Carlos Ruiz', '1985-07-30', 1, 'carlosruiz@example.com', 'pass3456', -53.1638, -70.9171),
('20000004-5', 'María López', '1992-08-25', 1, 'marialopez@example.com', 'pass7890', -23.6509, -70.3975),
('20000005-6', 'Diego Morales', '1987-09-10', 1, 'diegomorales@example.com', 'pass2345', -27.3668, -70.3322),
('20000006-7', 'Lucía Fernández', '1991-10-05', 1, 'luciafernandez@example.com', 'pass6789', -39.8142, -73.2459),
('20000007-8', 'Roberto Díaz', '1984-11-20', 1, 'robertodiaz@example.com', 'pass1235', -20.2208, -70.1431),
('20000008-9', 'Carmen Soto', '1993-12-15', 1, 'carmensoto@example.com', 'pass4567', -29.9533, -71.3395),
('20000009-0', 'Francisco Vargas', '1989-01-10', 1, 'franciscovargas@example.com', 'pass7891', -33.4378, -70.6504),
('20000010-1', 'Elena Núñez', '1995-02-14', 1, 'elenanunez@example.com', 'pass8901', -41.4689, -72.9411),
('20000011-2', 'Miguel Ángel Torres', '1986-03-19', 1, 'miguelangel@example.com', 'pass5671', -22.9087, -68.1997),
('20000012-3', 'Isabel Castillo', '1994-04-23', 1, 'isabelcastillo@example.com', 'pass6782', -33.0153, -71.5500),
('20000013-4', 'Jorge Martínez', '1983-05-28', 1, 'jorgemartinez@example.com', 'pass7893', -36.6066, -72.1023),
('20000014-5', 'Daniela Vidal', '1996-06-02', 1, 'danielavidal@example.com', 'pass8904', -53.7850, -67.7500),
('20000015-6', 'Andrés Guerrero', '1982-07-07', 1, 'andresguerrero@example.com', 'pass9015', -18.4783, -70.3126),
('20000016-7', 'Verónica Moya', '1997-08-12', 1, 'veronicamoya@example.com', 'pass0126', -33.4569, -70.6483),
('20000017-8', 'Ricardo Tapia', '1981-09-17', 1, 'ricardotapia@example.com', 'pass1237', -29.9045, -71.2489),
('20000018-9', 'Sandra Contreras', '1998-10-22', 1, 'sandracontreras@example.com', 'pass2348', -35.4232, -71.6485),
('20000019-0', 'Luis Navarro', '1979-11-27', 1, 'luisnavarro@example.com', 'pass3459', -38.7359, -72.5904),
('20000020-1', 'Patricia Muñoz', '1980-12-31', 1, 'patriciamunoz@example.com', 'pass4560', -20.5352, -70.1813);


------------------------------------------
-- 2. Tabla Ability: 10 registros
------------------------------------------

INSERT INTO Ability (names, items, description) VALUES
('Extinción de incendios', 'Manguera, extintor', 'Habilidades para combatir incendios forestales'),
('Rescate de personas', 'Cuerdas, arnés', 'Habilidades para el rescate de personas atrapadas en terremotos'),
('Primeros auxilios', 'Botiquín, vendajes', 'Habilidades para brindar primeros auxilios en situaciones de emergencia'),
('Evacuación', 'Señalización, megáfono', 'Habilidades para organizar y llevar a cabo evacuaciones en caso de tsunamis'),
('Control de inundaciones', 'Bombas, sacos de arena', 'Habilidades para controlar aluviones e inundaciones'),
('Comunicaciones de emergencia', 'Radio, walkie-talkie', 'Habilidades para mantener comunicaciones efectivas durante situaciones de emergencia'),
('Coordinación de equipos', 'Planificación y gestión de recursos', 'Habilidades para coordinar equipos en situaciones de emergencia'),
('Manejo de drones', 'Drones y tecnología de control remoto', 'Habilidades para utilizar drones en operaciones de búsqueda y rescate'),
('Operación de maquinaria pesada', 'Excavadoras, bulldozers, etc.', 'Habilidades para operar maquinaria pesada en tareas de emergencia'),
('Logística de suministros', 'Gestión de inventario y distribución', 'Habilidades para administrar la logística de suministros de emergencia');

------------------------------------------
-- 3. Tabla Voluntary_Ability: 10 registros
------------------------------------------

INSERT INTO Voluntary_Ability (id_voluntary, id_ability) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

------------------------------------------
-- 4. Tabla Institution: 5 registros
------------------------------------------

INSERT INTO Institution (name, coordinator_name, email, password) VALUES
('Cruz Roja Chile', 'Ana Martínez', 'cruzroja@gmail.com', 'cruzroja123'),
('Bomberos de Santiago', 'Juan Pérez', 'bomberos@gmail.com', 'bomberos456'),
('Defensa Civil', 'María González', 'defensacivil@gmail.com', 'defensacivil789'),
('Carabineros de Chile', 'Carlos Rodríguez', 'carabineros@gmail.com', 'carabinerospass'),
('Municipalidad de Valparaíso', 'Laura Fernández', 'valparaiso@gmail.com', 'valparaisopass');

------------------------------------------
-- 5. Tabla Emergency: 5 registros
------------------------------------------

INSERT INTO Emergency (name, description, state, id_institution, latitude, longitude) VALUES
('Inundación en Valdivia', 'Fuertes lluvias causan inundaciones en Valdivia', 1, 3, -39.8196, -73.2452),
('Incendio en Viña del Mar', 'Gran incendio forestal en las cercanías de Viña del Mar', 1, 4, -33.0245, -71.5518),
('Terremoto en Concepción', 'Terremoto de gran magnitud afecta a Concepción', 1, 5, -36.8270, -73.0498),
('Aluvión en Atacama', 'Aluvión en la región de Atacama', 1, 2, -27.3666, -70.3322),
('Erupción Volcánica en Pucón', 'Erupción del volcán Villarrica cerca de Pucón', 1, 1, -39.2723, -71.9776),
('Deslizamiento en Chaitén', 'Deslizamiento de tierra en la zona de Chaitén', 1, 5, -42.9186, -72.7164),
('Tormenta en Punta Arenas', 'Tormenta severa golpea Punta Arenas', 1, 2, -53.1638, -70.9171),
('Incendio en Valparaíso', 'Incendio urbano en varios sectores de Valparaíso', 1, 1, -33.0472, -71.6127),
('Sequía en Coquimbo', 'Sequía extrema afecta la región de Coquimbo', 1, 3, -29.9533, -71.3395),
('Contaminación en Santiago', 'Alta contaminación del aire en Santiago', 1, 2, -33.4489, -70.6693);

------------------------------------------
-- 6. Tabla Emergency_Voluntary: 5 registros
------------------------------------------
INSERT INTO Emergency_Ability (id_emergency, id_ability) VALUES
(1, 2),
(2, 1),
(3, 3),
(4, 5),
(5, 4);

------------------------------------------
-- 7. Tabla Task: 10 registros
------------------------------------------

INSERT INTO Task (name, description, state, id_emergency) VALUES
('Evacuación de personas', 'Coordinar la evacuación de residentes en áreas afectadas por el incendio.', 1, 1),
('Rescate de heridos', 'Realizar el rescate de personas atrapadas en edificios colapsados después del terremoto.', 1, 2),
('Asistencia médica de primeros auxilios', 'Brindar atención médica de primeros auxilios a personas heridas.', 1, 3),
('Control de inundaciones', 'Coordinar esfuerzos para controlar las inundaciones y proteger áreas vulnerables.', 1, 4),
('Comunicaciones de emergencia', 'Mantener comunicaciones efectivas durante situaciones de emergencia.', 1, 5),
('Evacuación costera', 'Organizar y llevar a cabo la evacuación de áreas costeras ante una alerta de tsunami.', 1, 1),
('Extinción de incendios forestales', 'Combatir y controlar los incendios forestales en áreas afectadas.', 1, 2),
('Distribución de suministros', 'Distribuir suministros de emergencia a personas afectadas por el desastre.', 1, 3),
('Apoyo psicológico', 'Brindar apoyo emocional y asistencia psicológica a las víctimas de la emergencia.', 1, 4),
('Búsqueda y rescate en aluviones', 'Realizar operaciones de búsqueda y rescate en áreas afectadas por un aluvión.', 1, 5);

------------------------------------------
-- 8. Tabla Task_Ability: 10 registros
------------------------------------------

INSERT INTO Task_Ability (id_task, id_ability) VALUES
(1, 4),
(2, 2),
(3, 3),
(4, 5),
(5, 6),
(6, 7),
(7, 1),
(8, 8),
(9, 9),
(10, 10);

------------------------------------------
-- 9. Tabla Ranking: 10 registros
------------------------------------------

INSERT INTO Ranking (id_task, id_voluntary) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
