# Build stage

FROM maven:3-eclipse-temurin-21 AS builder

LABEL MAINTAINER="darrylng@nus.edu.sg"
LABEL APPLICATION="Healthcheck Application"

WORKDIR /usr/app

ARG APP_DIR=/app
WORKDIR ${APP_DIR}

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true


# Publish stage
FROM openjdk:21-jdk

ARG APP_DIR=/app
WORKDIR ${APP_DIR}

COPY --from=builder /app/target/d18-lecture-0.0.1-SNAPSHOT.jar healthcheck.jar 

# e.g. java -jar healthcheck.jar
# ENTRYPOINT [ "java", "-jar", "healthcheck.jar" ]

# e.g. /bin/sh -c "java -jar healthcheck.jar"
ENTRYPOINT java -jar healthcheck.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:8080/demo/healthz || exit 1