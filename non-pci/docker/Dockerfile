FROM frolvlad/alpine-oraclejdk8:slim


# Application setup
VOLUME /tmp
ADD non-pci-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

