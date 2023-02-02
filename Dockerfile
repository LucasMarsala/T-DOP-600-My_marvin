FROM jenkins/jenkins:lts

Workdir /Marvin

EXPOSE 8080

COPY job_dsl.groovy .

COPY my_marvin.yml .
