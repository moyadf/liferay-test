create table dbsystem_Ciudades (
	ciudadId LONG not null primary key,
	ciudad VARCHAR(75) null,
	estado BOOLEAN
);

create table dbsystem_Cliente (
	clienteId LONG not null primary key,
	groupId LONG,
	tipoDocumento LONG,
	numeroDocumento VARCHAR(75) null,
	nombres VARCHAR(75) null,
	apellidos VARCHAR(75) null,
	celular VARCHAR(75) null,
	email VARCHAR(75) null,
	estado BOOLEAN
);

create table dbsystem_ClienteVehiculo (
	clienteVehiculoId LONG not null primary key,
	clienteId LONG,
	concesionarioId LONG,
	vehiculoId LONG
);

create table dbsystem_Concesionario (
	concesionarioId LONG not null primary key,
	ciudadId LONG,
	concesionario VARCHAR(75) null,
	estado BOOLEAN
);

create table dbsystem_ConcesionarioVehiculo (
	concesionarioVehiculoId LONG not null primary key,
	concesionarioId LONG,
	vehiculoId LONG
);

create table dbsystem_Vehiculo (
	vehiculoId LONG not null primary key,
	vehiculo VARCHAR(75) null,
	estado BOOLEAN
);