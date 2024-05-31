# poc-tps

## Deploy apps on OpenShift
``` mvn clean package -Dquarkus.openshift.deploy=true```

## SonarQube
```
    oc new-project cicd
    helm repo add redhat-cop https://redhat-cop.github.io/helm-charts
    helm upgrade --install sonar redhat-cop/sonarqube -n cicd
```
admin/admin

### Rest endpoint
```
    curl --location 'http://simple-rest-poc-tps.apps.[cluster]/cxf/simpleRest/save' \
     --header 'Response-Type: application/json' \ 
     --header 'Content-Type: application/x-www-form-urlencoded' \
     --header 'Cookie: CookieConsentPolicy=0:1; LSKey-c$CookieConsentPolicy=0:1' \
     --data-urlencode 'token=RMIaJFyPTxG22xZOCBIhK6igjtZUmXO4YWeVwsW2M7O40eWATWTdtTug5DVeFDRf' \
     --data-urlencode 'nombre=jean' | jq
```

### SOAP endpoint
```

```


### Pipelines
```
    oc apply -f pvc.yaml -n poc-tps
    oc apply -f maven-task.yaml -n poc-tps
    oc apply -f maven-pipeline.yaml -n poc-tps
    oc apply -f maven-pipelinerun.yaml -n poc-tps
```

### Quay.io
Podman on macOS:
```
    oc create secret generic poc-tps-quay-credentials \
    --from-file=.dockercfg=$HOME/.config/containers/auth.json \
    --type=kubernetes.io/dockercfg

    oc secrets link builder poc-tps-quay-credentials
```

### ArgoCD
