FROM eclipse-temurin:17-jdk-alpine AS BUILDER

RUN mkdir /app_source
COPY . /app_source

WORKDIR /app_source

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM eclipse-temurin:17-jdk-alpine AS RUNNER

RUN mkdir /app

COPY --from=BUILDER /app_source/build/libs /app

WORKDIR /app

ENV TZ=Asia/Seoul

EXPOSE 8080
USER nobody

ARG PHASE
ARG FILES_PATH

ENV ENV_PHASE=${PHASE}
ENV ENV_FILES_PATH=${FILES_PATH}

ENTRYPOINT java -jar \
  -Dspring.profiles.active=${ENV_PHASE:-local} \
  -Dcloud.files.path=${ENV_FILES_PATH} \
  /app/*.jar
