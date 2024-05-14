FROM openjdk:17

EXPOSE 8082

ADD ./target/Bmed_Medicos-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
