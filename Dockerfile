FROM maven:3-eclipse-temurin-21

LABEL MAINTAINER="darrylng@nus.edu.sg"
LABEL APPLICATION="Healthcheck Application"

WORKDIR /usr/app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

#COPY /target/d18-lecture-0.0.1-SNAPSHOT.jar healthcheck.jar

ENTRYPOINT [ "java", "-jar", "target/d18-lecture-0.0.1-SNAPSHOT.jar" ]

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:8080/demo/healthz || exit 1