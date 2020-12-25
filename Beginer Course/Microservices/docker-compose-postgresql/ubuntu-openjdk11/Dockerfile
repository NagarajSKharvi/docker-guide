# Updated as of Nov 21, 2020
FROM ubuntu:20.04

#Author of the Docker File
# MAINTAINER Nagaraj Note: MAINTAINER has been deprecated for LABEL, 
# LABEL is a key value pair 
LABEL "Maintainer"="Nagaraj"

# install packages
RUN apt-get update && \
    apt-get install -y curl \
    wget

RUN apt-get install -y openjdk-11-jdk
RUN apt install -y maven