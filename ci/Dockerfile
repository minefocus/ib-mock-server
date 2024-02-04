FROM openjdk:8-jdk

MAINTAINER WBT Pactera

ARG PACKAGE_FILE_NAME
ARG PROFILE

EXPOSE 8080

ENV TZ=Asia/Tokyo 

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone

RUN ["apt-get", "purge", "-y", "git"]
RUN ["apt-get", "remove", "-y","--allow-remove-essential", "apt"]

COPY target/$PACKAGE_FILE_NAME.jar ROOT.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /ROOT.jar
