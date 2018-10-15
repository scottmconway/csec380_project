#!/bin/bash

cd $TRAVIS_BUILD_DIR/Authentication

docker-compose up

docker ps