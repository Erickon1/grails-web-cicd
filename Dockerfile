FROM 997732206623.dkr.ecr.us-east-1.amazonaws.com/openjdk11:latest
COPY build/libs/mercado-0.1.war app.war
ENTRYPOINT ["java", "-jar", "/app.war"]
