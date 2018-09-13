#!/bin/sh

cd tests/helloworld/

docker build -t csec380_project/helloworld .
docker run -d -p 80:80 csec380_project/helloworld
docker ps -a