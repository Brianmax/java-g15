select * from aerolineas;

select * from aviones;

select * from pasajeros;
select * from boletos;

-- Para obtener una lista de todas las aerolíneas junto con los aviones que tienen
select * from aerolineas JOIN aviones ON aviones.id_aerolinea_fk = aerolineas.id_aerolinea;

-- Lista de pasajeros con sus respectivos boletos

select pasajeros.nombre, pasajeros.apellido, boletos.asiento from pasajeros JOIN boletos on boletos.id_pasajero_fk = pasajeros.id_pasajero;

-- Lista de aerolineaas sin aviones y con aviones (left join)

select * from aerolineas LEFT JOIN aviones ON aviones.id_aerolinea_fk = aerolineas.id_aerolinea;

-- left outter join para obtener solo las aerolíneas sin aviones

select * from aerolineas left join aviones ON aviones.id_aerolinea_fk = aerolineas.id_aerolinea where aviones.id_aerolinea_fk is null;


select * from vuelos;

-- traer pasajero con su boleto y su vuelo
select pasajeros.nombre, pasajeros.apellido, boletos.asiento, vuelos.destino from pasajeros 
JOIN boletos on boletos.id_pasajero_fk = pasajeros.id_pasajero 
JOIN vuelos on vuelos.id_vuelo = boletos.id_vuelo_fk;