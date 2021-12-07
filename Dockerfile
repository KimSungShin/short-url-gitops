# base image
FROM openjdk:8-jdk-alpine

EXPOSE 8080

# set working directory
WORKDIR /application

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

# environment variables 
ENV JAVA_OPTS="-Dspring.profiles.active=dev"

CMD java $JAVA_OPTS -jar app.jar