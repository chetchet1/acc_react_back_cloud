FROM openjdk:17-jdk-slim

WORKDIR /app

# 타임존 패키지 설치 및 설정
RUN apt-get update && \
    apt-get install -y tzdata && \
    ln -fs /usr/share/zoneinfo/UTC /etc/localtime && \
    dpkg-reconfigure --frontend noninteractive tzdata

# WAR 파일을 Docker 이미지로 복사
COPY build/libs/account3rd-0.0.1-SNAPSHOT.war /app/app.war

# 포트 노출
EXPOSE 9103

# WAR 파일을 실행
ENTRYPOINT ["java", "-jar", "/app/app.war"]

ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092