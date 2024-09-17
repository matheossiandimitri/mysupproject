FROM maven:3.9.5-eclipse-temurin-21-alpine AS java-build

WORKDIR /app/

COPY .mvn/ .mvn
COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -DskipTests -P docker
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:21-jre-alpine

ARG DEPENDENCY=/app/target/dependency
# dependencies
COPY --from=java-build ${DEPENDENCY}/BOOT-INF/lib /app/lib
# metadata
COPY --from=java-build ${DEPENDENCY}/META-INF /app/META-INF
# java classes
COPY --from=java-build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 7010

ENTRYPOINT ["java","-cp","app:app/lib/*","com.dim.job_offers_service.JobOffersServiceApplication"]