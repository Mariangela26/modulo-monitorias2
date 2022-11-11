ARG BUILD_IMAGE=gradle:6.7.1-jdk11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as dependencies
ENV APP_HOME=/
WORKDIR $APP_HOME

RUN mkdir common && mkdir talent
COPY /common/ /common/
COPY /plantilla/ /plantilla/
WORKDIR /plantilla/

RUN gradle build -x test -x checkstyleMain -x checkstyleTest

FROM ${RUNTIME_IMAGE}
ENV ARTIFACT_NAME=*.jar
ENV PROFILE=dev

EXPOSE 8080

COPY --from=dependencies /talent/build/libs/$ARTIFACT_NAME /app/test.jar
CMD ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/app/test.jar"]