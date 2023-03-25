# Rental App

This project was generated with:
> [Angular CLI](https://github.com/angular/angular-cli) version 14.1.0.  

> [Spring Boot](https://spring.io/projects/spring-boot) version 3.0.4.

> [OpenJDK](https://openjdk.org/projects/jdk/19/) version 17.0.1.

> [Spring Security](https://spring.io/projects/spring-security) version 6.0.0.

## Start the project

Git clone:

> git clone https://github.com/Asediab/P3-Full-Stack-portail-locataire

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

Configure your database connection in `back-end/src/main/resources/application.properties`

Install dependencies:

> mvn install

Launch Back-end:

> mvn spring-boot:run

Endpoints are available at http://localhost:8080/

Swagger is available at http://localhost:8080/swagger-ui/index.html#/

## Ressources
### Postman collection

For Postman import the collection

> ressources/postman/rental.postman_collection.json 

by following the documentation: 

https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-data-into-postman


### MySQL

SQL script for creating the schema is available `ressources/sql/script.sql`
