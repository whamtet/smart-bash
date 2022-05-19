FROM openjdk:8-alpine

COPY target/uberjar/smart-bash.jar /smart-bash/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/smart-bash/app.jar"]
