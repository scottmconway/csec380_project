FROM openjdk:7-alpine

COPY auth_app /usr/src/auth_app
WORKDIR /usr/src/auth_app
RUN javac Main.java
CMD ["java", "Main"]