#!/bin/bash
cd api && mvn clean install && cd .. && docker-compose up --build

