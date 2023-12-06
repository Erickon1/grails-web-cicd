FROM openjdk:11
COPY build/libs/mercado-0.1.war app.war
ENTRYPOINT ["java", "-jar", "/app.war"]
