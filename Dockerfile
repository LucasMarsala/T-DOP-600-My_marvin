FROM jenkins/jenkins:lts

EXPOSE 8080

Workdir /Marvin

#ARG JAVA_OPTS

#ENV JAVA_OPTS="-Djenkins.CLI.disabled=true ${JAVA_OPTS:-}"

COPY --chown=jenkins:jenkins /plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt

COPY --chown=jenkins:jenkins /jobs/job_dsl.groovy /usr/share/jenkins/ref/init.groovy.d/job_dsl.groovy

COPY --chown=jenkins:jenkins /configuration/my_marvin.yml /var/jenkins_home/casc_configs/my_marvin.yml

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
