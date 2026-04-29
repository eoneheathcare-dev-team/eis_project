# 1. 자바 17 실행 환경 (알파인 리눅스로 가볍게)
FROM eclipse-temurin:17-jdk-alpine

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 시간대 설정 (한국 시간)
RUN apk add --no-cache tzdata
ENV TZ=Asia/Seoul

# 4. 젠킨스가 만들어둔 JAR 파일의 위치 (Gradle 기준)
ARG JAR_FILE=build/libs/*.jar

# 5. JAR 파일을 도커 컨테이너 내부로 복사
COPY ${JAR_FILE} app.jar

# 6. 앱 실행 (포트는 8080 고정, 환경은 dev)
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "app.jar"]