CREATE SCHEMA control_libreria DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

use control_libreria;

create table configuracion(
idConfig int(20) not null auto_increment primary key,
configuracion varchar(300) not null,
valor varchar(300) not null,
cargo varchar(100) not null
);

create table usuarios(
idUsuario int(20) not null auto_increment primary key,
nombreUser varchar(100) not null,
contra varchar(100) not null,
nombre varchar(100) not null,
apellido varchar(100) not null,
correo varchar(100) not null,
cargo varchar(100) not null
);

create table articulos(
idArticulo int(20) not null auto_increment primary key,
codigoArticulo varchar(10) not null,
nombreArticulo varchar(260) not null,
proveedor varchar(100) not null
);

create table registroCompras(
idregistro int(20) not null auto_increment primary key,
idArticulo int(20) not null,
fecha datetime,
concepto varchar(260),
precioUnit double not null,
cantidad int(10),
idUsuario int(20) not null
);

ALTER TABLE registroCompras ADD CONSTRAINT fkComprasArticulo foreign key (idArticulo) references articulos (idArticulo);
ALTER TABLE registroCompras ADD CONSTRAINT fkComprasUsuario foreign key (idUsuario) references usuarios (idUsuario);

INSERT INTO usuarios(nombreUser, contra, nombre, apellido, correo, cargo)
VALUES ('admin','admin', 'Administrador', 'General', 'admin@gmail.com', 'Administrador');