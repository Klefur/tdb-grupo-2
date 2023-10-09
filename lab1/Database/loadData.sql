------------------------------------------
-- 1. Tabla Voluntary: 10 registros
------------------------------------------

INSERT INTO "Voluntary" (rut, fullname, birthday, state, email, password) VALUES
('98765432-1', 'María González', '1985-03-15', 1, 'mariagonzalez@gmail.com', 'p@ssw0rd'),
('76543210-8', 'Carlos Rodríguez', '1992-07-20', 1, 'carlosrodriguez@gmail.com', 'securepass'),
('54321098-7', 'Ana López', '1988-11-10', 1, 'analopez@gmail.com', 'mysecret123'),
('32109876-5', 'Pedro Martínez', '1995-04-05', 1, 'pedromartinez@gmail.com', 'ilovecoding'),
('87654321-0', 'Laura Fernández', '1987-09-25', 1, 'laurafernandez@gmail.com', '12345678'),
('98765432-1', 'María González', '1985-03-15', 1, 'mariagonzalez@gmail.com', 'p@ssw0rd'),
('76543210-8', 'Carlos Rodríguez', '1992-07-20', 1, 'carlosrodriguez@gmail.com', 'securepass'),
('54321098-7', 'Ana López', '1988-11-10', 1, 'analopez@gmail.com', 'mysecret123'),
('32109876-5', 'Pedro Martínez', '1995-04-05', 1, 'pedromartinez@gmail.com', 'ilovecoding'),
('87654321-0', 'Laura Fernández', '1987-09-25', 1, 'laurafernandez@gmail.com', '12345678');

------------------------------------------
-- 2. Tabla Ability: 10 registros
------------------------------------------

INSERT INTO "Ability" (names, items, description) VALUES
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

INSERT INTO "Voluntary_Ability" (id_voluntary, id_ability) VALUES
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

INSERT INTO "Institution" (name, coordinator_name, email, password) VALUES
('Cruz Roja Chile', 'Ana Martínez', 'cruzroja@gmail.com', 'cruzroja123'),
('Bomberos de Santiago', 'Juan Pérez', 'bomberos@gmail.com', 'bomberos456'),
('Defensa Civil', 'María González', 'defensacivil@gmail.com', 'defensacivil789'),
('Carabineros de Chile', 'Carlos Rodríguez', 'carabineros@gmail.com', 'carabinerospass'),
('Municipalidad de Valparaíso', 'Laura Fernández', 'valparaiso@gmail.com', 'valparaisopass');

------------------------------------------
-- 5. Tabla Emergency: 5 registros
------------------------------------------

INSERT INTO "Emergency" (name, description, state, id_institution) VALUES
('Incendio Forestal en Valparaíso', 'Incendio forestal en la zona de Valparaíso', 1, 1),
('Terremoto en Santiago', 'Terremoto de magnitud 7.5 en Santiago', 1, 2),
('Inundaciones en Concepción', 'Inundaciones debido a fuertes lluvias en Concepción', 1, 5),
('Tsunami en Viña del Mar', 'Alerta de tsunami en la costa de Viña del Mar', 1, 3),
('Aluvión en Antofagasta', 'Aluvión en la región de Antofagasta', 1, 4);

------------------------------------------
-- 6. Tabla Emergency_Voluntary: 5 registros
------------------------------------------
INSERT INTO "Emergency_Ability" (id_emergency, id_ability) VALUES
(1, 2),
(2, 1),
(3, 3),
(4, 5),
(5, 4);

------------------------------------------
-- 7. Tabla Task: 10 registros
------------------------------------------

INSERT INTO "Task" (name, description, state, id_institution) VALUES
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

INSERT INTO "Task_Ability" (id_task, id_ability) VALUES
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

INSERT INTO "Ranking" (id_task, id_voluntary) VALUES
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