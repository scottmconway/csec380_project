#!/bin/bash

cd $TRAVIS_BUILD_DIR

docker-compose up -d

docker ps
