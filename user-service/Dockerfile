FROM eclipse-temurin:21-jdk
EXPOSE 9090
ADD target/user-service-docker-image.jar user-service-docker-image.jar
ENTRYPOINT["java","-jar", "/user-service-docker-image.jar"]