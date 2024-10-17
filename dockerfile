FROM openjdk:21-oracle
COPY ./target/SpringSecurity-0.0.1-SNAPSHOT.jar spring-security.jar
CMD ["java","-jar","spring-security.jar"]