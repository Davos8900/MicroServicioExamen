#!/usr/bin/env sh

cd arquitectura-discovery-server
./generaImagen.sh
cd ../

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
