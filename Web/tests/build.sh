#!/bin/bash

cd $TRAVIS_BUILD_DIR/Web

docker-compose up -d

docker ps