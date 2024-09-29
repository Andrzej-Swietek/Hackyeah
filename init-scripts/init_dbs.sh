#!/bin/bash
set -e
echo "Creating databases: company, user, project, feed, keycloak, storage"

psql -v ON_ERROR_STOP=1 --username "hackyeah" --dbname "postgres"<<-EOSQL
    CREATE DATABASE company;
    CREATE DATABASE "user";
    CREATE DATABASE project;
    CREATE DATABASE feed;
    CREATE DATABASE keycloak;
    CREATE DATABASE storage;
EOSQL

echo "Multiple databases dropped and created successfully"
