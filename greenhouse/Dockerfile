# syntax=docker/dockerfile:experimental
ARG MAIN_CLASS
FROM eclipse-temurin:21 as build

WORKDIR /workspace/app

COPY . /workspace/app/

RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build -x test
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM eclipse-temurin:21
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.botanic.greenhouse.GreenhouseApplication"]