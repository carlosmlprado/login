FROM openjdk:8

WORKDIR /app

EXPOSE 8098

ADD target/login-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "login-0.0.1-SNAPSHOT.jar"]