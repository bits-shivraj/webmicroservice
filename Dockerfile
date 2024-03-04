FROM openjdk:17
WORKDIR /opt
ENV PORT 9009
EXPOSE 9009
COPY target/*.jar /opt/webservice.jar
ENTRYPOINT exec java -jar webservice.jar