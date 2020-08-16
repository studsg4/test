FROM openjdk:8-jdk-alpine
ADD target/studs-test.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]