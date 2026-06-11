# syntax=docker/dockerfile:1.7
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN --mount=type=cache,target=/root/.gradle chmod +x gradlew && ./gradlew clean build -x test

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/build/libs/eis_project-0.0.1-SNAPSHOT.jar app.jar
ENV TZ=Asia/Seoul
ENV SPRING_PROFILES_ACTIVE=window
RUN apk add --no-cache tzdata
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
