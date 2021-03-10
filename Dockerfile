FROM openjdk:7
COPY Npe.java .
RUN javac Npe.java
ENTRYPOINT [ "java", "Npe"]