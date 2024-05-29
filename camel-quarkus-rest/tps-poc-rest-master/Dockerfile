# Réplica de Dockerfile base para Openshift

FROM registry.access.redhat.com/ubi8/openjdk-17:1.19
ENV LANGUAGE='en_US:en'

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
EXPOSE 61616
ENV JAVA_OPTS_APPEND="-Dquarkus.http.port=8080"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]