FROM openjdk

RUN mkdir /desafio

ENV APP_NAME=desafio-1.jar

COPY target/${APP_NAME} /app/desafio/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/desafio-1.jar"]

