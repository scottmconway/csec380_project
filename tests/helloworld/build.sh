#!/bin/sh

cd tests/helloworld

docker build -t skittertests/helloworld .
docker run -d -p 80:80 skittertests/helloworld
docker ps
