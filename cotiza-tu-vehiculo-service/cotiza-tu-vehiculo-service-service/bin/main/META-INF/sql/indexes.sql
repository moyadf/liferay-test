create index IX_8FA3D48A on dbsystem_Ciudades (ciudad[$COLUMN_LENGTH:75$]);
create index IX_6E86E618 on dbsystem_Ciudades (estado);

create index IX_CE03BE26 on dbsystem_Cliente (tipoDocumento, numeroDocumento[$COLUMN_LENGTH:75$]);

create index IX_9990A77D on dbsystem_ClienteVehiculo (clienteId, concesionarioId, vehiculoId);
create index IX_3468DD27 on dbsystem_ClienteVehiculo (vehiculoId);

create index IX_5C0C7F65 on dbsystem_Concesionario (ciudadId, estado);

create index IX_62BC59C6 on dbsystem_ConcesionarioVehiculo (concesionarioId, vehiculoId);
create index IX_2C24F6DD on dbsystem_ConcesionarioVehiculo (vehiculoId);