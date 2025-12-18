FROM eclipse-temurin:21
LABEL authors="prashant.vasala"
WORKDIR /app
COPY target/HoursCalculator-0.0.1-SNAPSHOT.jar /app/HoursCalculator-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "HoursCalculator-0.0.1-SNAPSHOT.jar"]