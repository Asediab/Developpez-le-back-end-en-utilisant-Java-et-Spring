# Rental App

This project was generated with:
> [Angular CLI](https://github.com/angular/angular-cli) version 14.1.0.  

> [Spring Boot](https://spring.io/projects/spring-boot) version 3.0.4.

> [OpenJDK](https://openjdk.org/projects/jdk/19/) version 17.0.1.

> [Spring Security](https://spring.io/projects/spring-security) version 6.0.0.

## Start the project

Git clone:

> git clone https://github.com/Asediab/P3-Full-Stack-portail-locataire

MySQL (MySQL Community Server - GPL):

> Port: 3306

> Create the username and the password (`*`from noted values)

> Create a new schema named: test

> Give rights for this username on the test schema

Set the user's environment variables

> Variable for MySQL password: `DATA_SOURSCE_PASS`

> Variable for MySQL username: `DATA_SOURCE_USER`

> Variable for the JWT secret: `JWT_SECRET`

Go inside folder:

> cd Developpez-le-back-end-en-utilisant-Java-et-Spring

### Front-end

Install dependencies:

> npm install

Launch Front-end:

> npm run start;

Open your browser at http://localhost:4200/

### Back-end

Go inside folder:

> cd back-end

Install dependencies:

> mvn install

Launch Back-end:

> mvn spring-boot:run

Data tables and test data will be created automatically using FlyWay

Endpoints are available at http://localhost:8080/

Swagger is available at http://localhost:8080/swagger-ui/index.html#/
