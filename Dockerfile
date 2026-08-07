FROM eclipse-temurin:21-jdk

ADD target/LibraryMangementAPI-0.0.1-SNAPSHOT.jar libraryApp.jar
ENTRYPOINT ["java", "-jar", "libraryApp.jar"]