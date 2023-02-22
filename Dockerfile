FROM jenkins/jenkins:lts

Workdir /Marvin

EXPOSE 8080

COPY job_dsl.groovy /usr/share/jenkins/ref/init.groovy.d/job_dsl.groovy

COPY my_marvin.yml .
