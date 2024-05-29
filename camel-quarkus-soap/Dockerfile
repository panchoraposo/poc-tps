# Réplica de Dockerfile base para Openshift

FROM registry.access.redhat.com/ubi8/openjdk-17:1.19
ENV LANGUAGE='en_US:en'
ENV USER_TOKEN='RMIaJFyPTxG22xZOCBIhK6igjtZUmXO4YWeVwsW2M7O40eWATWTdtTug5DVeFDRf'
ENV LOGIN_GET='JEAN'
ENV PASSWORD_GET='123456'
ENV USER_GET_INFO='NOMBRE @NOMBRE DE @DOMINIO'

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8181
EXPOSE 61616
ENV JAVA_OPTS_APPEND="-Dquarkus.http.port=8181"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]