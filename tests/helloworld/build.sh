#!/bin/sh

cd tests/helloworld

docker build -t skitterTests/helloworld .
docker run -d -p 80:80 skitterTests/helloworld
docker ps
