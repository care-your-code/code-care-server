FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "-Dspring.profiles.active=dev" ,"java ${JAVA_OPTS} -jar /app.jar"]
