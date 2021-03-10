# Java NPE

This project simulates a POD that breaks with a NullPointerException and shows a workaround to evatulate the container preventing it to break.

# Failing in 5 seconds

If you just apply the `npe5seconds-pod.yaml` it will fail in 5 seconds with a NPE...

```bash
kubectl apply -f npe5seconds-pod.yaml  && sleep 3 &&  kubectl logs -f npe5seconds
```

# Preventing the POD to break

The `npe5seconds-pod-extended.yaml` POD configuration overrides the docker ENTRYPOINT with a `sleep 3600` what allows us to get into the the container and execute the test manually.

```bash
edeoliveira:~/Documents/projects/java-npe
$ kubectl delete pod npe5seconds
pod "npe5seconds" deleted

edeoliveira:~/Documents/projects/java-npe
$ kubectl apply -f npe5seconds-pod-extended.yaml
pod/npe5seconds created

edeoliveira:~/Documents/projects/java-npe
$ k logs npe5seconds
Sleeping 3600 seconds

edeoliveira:~/Documents/projects/java-npe
$ k exec npe5seconds -ti -- /bin/sh
# hostname
npe5seconds
# ls
Npe.class  Npe.java  bin  boot	dev  docker-java-home  etc  home  lib  lib64  media  mnt  opt  proc  root  run	sbin  srv  sys	tmp  usr  var
# java Npe
Sleeping 5000 seconds
End of sleep... Will throw a NullPointerException now
Exception in thread "main" java.lang.NullPointerException
	at Npe.main(Npe.java:12)
# hostname
npe5seconds
#
```