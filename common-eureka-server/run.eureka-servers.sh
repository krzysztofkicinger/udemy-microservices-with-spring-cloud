#!/usr/bin/env bash

mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=primary" &
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=secondary" &
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=ternary"