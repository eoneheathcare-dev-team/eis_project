FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew clean build -x test && find build/libs -name "*.jar" ! -name "*-plain.jar" -exec cp {} /app/app.jar \;

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/build/libs/eis_project-0.0.1-SNAPSHOT.jar app.jar
ENV TZ=Asia/Seoul
ENV SPRING_PROFILES_ACTIVE=window
RUN apk add --no-cache tzdata
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
