FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/innova.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]