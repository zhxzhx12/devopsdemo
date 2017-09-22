FROM openjdk:8-jdk-alpine
ENV pro_dir=/app

VOLUME /tmp

ADD ../../../libs/test-gradle-web-content-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
