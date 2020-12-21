FROM kharvinagaraj1/ubuntu-openjdk11:1.0

#Author of the Docker File
# MAINTAINER Pictolearn Note: MAINTAINER has been deprecated for LABEL, 
# LABEL is a key value pair 
LABEL "Maintainer"="Nagaraj S Kharvi"

ADD . /usr/local/spring-boot-postgres
RUN cd /usr/local/spring-boot-postgres && mvn install
CMD ["java", "-jar", "/usr/local/spring-boot-postgres/target/spring-boot-postgres-0.0.1-SNAPSHOT.jar"]