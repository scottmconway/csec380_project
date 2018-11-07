#!/bin/bash

cd $TRAVIS_BUILD_DIR/Database/Elastic/

docker-compose up -d

docker ps