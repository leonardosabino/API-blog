# Introduction 
 This project was developed with the aim of managing the different posts of me blog 

### Requirements
- [Java 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html) ou superior
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Getting Started
1) Clone or download the project
2) Use the follow command to build the project
 ```
 mvn clean install
 ```
3) Start the mongodb database
 ```
 docker-compose up
 ```
4) The last step is execute the spring application
 ```
 mvn spring-boot:run
 ```

###	API references
  You can find the API documentation after starter the project
  ```
  localhosat:8081/swagger-ui/
  ```

