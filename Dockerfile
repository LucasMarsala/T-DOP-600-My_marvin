FROM jenkins/jenkins:lts

EXPOSE 8080

Workdir /Marvin

COPY --chown=jenkins:jenkins /plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

COPY --chown=jenkins:jenkins /configuration/my_marvin.yml /var/jenkins_home/casc_configs/my_marvin.yml

COPY --chown=jenkins:jenkins /jobs/job_dsl.groovy .
