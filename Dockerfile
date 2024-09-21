#FROM openjdk:11
#WORKDIR /opt
#ENV PORT 8080
#EXPOSE 8080
#COPY target/bloging-0.0.1-SNAPSHOT.jar /opt/app.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/bloging-0.0.1-SNAPSHOT.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","blog.jar"]

