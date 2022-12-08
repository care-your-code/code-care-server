FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
<<<<<<< HEAD
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar -Dspring.profiles.active=dev /app.jar"]

