// Conectar a MongoDB
conn = new Mongo();
db = conn.getDB("lab3");

// Insertar habilidades en la colección 'Ability'
const abilities = [
    { code: "FIRE", name: "Extinción de incendios", items: ["Manguera", "extintor"], description: "Habilidades para combatir incendios forestales" },
    { code: "RESC", name: "Rescate de personas", items: ["Cuerdas", "arnés"], description: "Habilidades para el rescate de personas atrapadas en terremotos" },
    { code: "AUX1", name: "Primeros auxilios", items: ["Botiquín", "camilla"], description: "Habilidades para la atención de primeros auxilios"},
    { code: "INUN2", name: "Control de inundaciones", items: ["Bombas", "mangueras"], description: "Habilidades para el control de inundaciones"},
    { code: "DRON1", name: "Manejo de drones", items: ["Drones", "cargador"], description: "Habilidades para el manejo de drones"},
    { code: "MAQ10", name: "Operación de maquinaria pesada", items: ["Retroexcavadora", "camión"], description: "Habilidades para la operación de maquinaria pesada"},
    { code: "ELEC1", name: "Electricidad", items: ["Cables", "focos"], description: "Habilidades para la reparación de instalaciones eléctricas"},
    { code: "MEDI1", name: "Medicina", items: ["Botiquín", "camilla"], description: "Habilidades para la atención de primeros auxilios"},
    { code: "COMU1", name: "Comunicaciones", items: ["Radios", "antenas"], description: "Habilidades para el manejo de comunicaciones"},
    { code: "TRAN1", name: "Transporte", items: ["Camión", "camioneta"], description: "Habilidades para el manejo de transporte"},
    { code: "ALIM1", name: "Alimentación", items: ["Cocina", "alimentos"], description: "Habilidades para la preparación de alimentos"},
    { code: "PSIC1", name: "Psicología", items: ["Libros", "cuadernos"], description: "Habilidades para la atención psicológica"},
    { code: "VETE1", name: "Veterinaria", items: ["Medicamentos", "jeringas"], description: "Habilidades para la atención veterinaria"}
];

abilities.forEach(ability => {
    db.Ability.insert(ability);
});

// Insertar voluntarios en la colección 'Voluntary'
const voluntaries = [
    { rut: "20000002-3", fullname: "Ana Gómez", birthday: new Date("1990-06-20"), state: 1, latitude: -39.8201, longitude: -73.2457, geom: "POINT(-73.2457 -39.8201)", abilities: [db.Ability.findOne({ code: "FIRE" }), db.Ability.findOne({ code: "RESC" })] },
    { rut: "20000003-4", fullname: "Carlos Rojas", birthday: new Date("1985-12-10"), state: 1, latitude: -39.8156, longitude: -73.2424, geom: "POINT(-73.2424 -39.8156)", abilities: [db.Ability.findOne({ code: "AUX1" }), db.Ability.findOne({code: "MEDI1"}), db.Ability.findOne({code: "DRON1"})] },
    { rut: "20000004-5", fullname: "María Soto", birthday: new Date("1992-08-05"), state: 1, latitude: -39.8178, longitude: -73.2434, geom: "POINT(-73.2434 -39.8178)", abilities: [db.Ability.findOne({ code: "MAQ10" }), db.Ability.findOne({ code: "COMU1"})] },
    { rut: "20000005-6", fullname: "Pedro Torres", birthday: new Date("1987-11-30"), state: 1, latitude: -39.8184, longitude: -73.2427, geom: "POINT(-73.2427 -39.8184)", abilities: [db.Ability.findOne({ code: "ELEC1" }), db.Ability.findOne({code: "MEDI1"}), db.Ability.findOne({code: "DRON1"})] },
    { rut: "20000006-7", fullname: "Carmen Vásquez", birthday: new Date("1991-02-25"), state: 1, latitude: -39.8198, longitude: -73.2447, geom: "POINT(-73.2447 -39.8198)", abilities: [db.Ability.findOne({ code: "RESC" }), db.Ability.findOne({code: "MEDI1"}), db.Ability.findOne({code: "PSIC1"})] },
    { rut: "20000007-8", fullname: "José González", birthday: new Date("1989-09-20"), state: 1, latitude: -39.8193, longitude: -73.2440, geom: "POINT(-73.2440 -39.8193)", abilities: [db.Ability.findOne({ code: "INUN2" }), db.Ability.findOne({code: "ALIM1"}), db.Ability.findOne({code: "DRON1"})] },
    { rut: "20000008-9", fullname: "Paula Muñoz", birthday: new Date("1986-03-15"), state: 1, latitude: -39.8202, longitude: -73.2452, geom: "POINT(-73.2452 -39.8202)", abilities: [db.Ability.findOne({ code: "VETE1" }), db.Ability.findOne({code: "MEDI1"}), db.Ability.findOne({code: "TRAN1"})] },
    { rut: "20000009-0", fullname: "Luisa Fuentes", birthday: new Date("1993-07-10"), state: 1, latitude: -39.8206, longitude: -73.2459, geom: "POINT(-73.2459 -39.8206)", abilities: [db.Ability.findOne({ code: "FIRE" }), db.Ability.findOne({code: "VETE1"}), db.Ability.findOne({code: "PSIC1"})] },
];

voluntaries.forEach(voluntary => {
    db.Voluntary.insert(voluntary);
});
