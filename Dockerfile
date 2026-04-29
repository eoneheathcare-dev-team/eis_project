FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
# Gradle 빌드 실행
RUN chmod +x gradlew && ./gradlew clean build -x test

# 2단계: 실행 환경
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar
ENV TZ=Asia/Seoul
RUN apk add --no-cache tzdata
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "app.jar"]