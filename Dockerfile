FROM openjdk:8
ADD target/ecartproductsvc.jar ecartproductsvc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ecartproductsvc.jar"]