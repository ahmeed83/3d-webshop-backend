#!/bin/bash

docker stop webshop-3d-psql

docker rm webshop-3d-psql

docker run --name webshop-3d-psql -p 5432:5432 -e POSTGRES_DB=webshop3d -e POSTGRES_PASSWORD=docker3d -d postgres

now=$(date +"%r")
echo "Current time : $now"