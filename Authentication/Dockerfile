FROM openjdk:8

COPY auth_server /usr/src/auth_server
WORKDIR /usr/src/auth_server
RUN chmod +x gradlew
RUN ./gradlew build

EXPOSE 8080
CMD java -jar build/libs/ldap-auth-server-0.1.0.jar
