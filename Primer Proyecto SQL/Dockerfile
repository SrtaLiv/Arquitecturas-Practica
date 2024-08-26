FROM openjdk:17-jdk-slim
ARG JAR_FILE
COPY ${JAR_FILE} primerproyecto.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "primerproyecto.jar" ]