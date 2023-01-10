FROM postgres:11.18-alpine

COPY base-datos.sh /docker-entrypoint-initdb.d/

RUN chmod +x /docker-entrypoint-initdb.d/base-datos.sh
