CREATE TABLE usuarios (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  edad Integer,
  email VARCHAR(255) NOT NULL,
  tag	VARCHAR(255),
  password	VARCHAR(255) NOT NULL
);

CREATE TABLE solicitudes_amistad (
  id      VARCHAR(255) PRIMARY KEY,
  usuario_genera VARCHAR(255) NOT NULL,
  usuario_recibe VARCHAR(255) NOT NULL,
  aceptada BOOLEAN DEFAULT FALSE
);

CREATE TABLE amigos (
  id_usuario VARCHAR(255) NOT NULL,
  id_amigo VARCHAR(255) NOT NULL,
  fecha_amistad VARCHAR(500) NOT NULL,
  parentesco VARCHAR(500) NOT NULL
);

CREATE TABLE posts (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  propietario VARCHAR(255) NOT NULL,
  propietario_tag VARCHAR(255) NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  mensaje VARCHAR(255) NOT NULL,
  adjunto VARCHAR(255),
  fecha_post VARCHAR(500) NOT NULL
);

CREATE TABLE comentarios (
  id_post VARCHAR(255) NOT NULL PRIMARY KEY,
  id_usuario VARCHAR(255) NOT NULL,
  mensaje VARCHAR(255) NOT NULL,
  fecha_post VARCHAR(500) NOT NULL
);
