# Library Management API

A RESTful Library Management API built using **Java and Spring Boot**.
The application manages books, categories, users, and loans with MySQL database integration.

## Technologies Used

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA / Hibernate
* MySQL
* Docker
* Maven
* JUnit 5
* Mockito
* JaCoCo
* Spring AOP

## Features

* Manage books
* Manage categories
* Manage users
* Manage loans
* CRUD operations
* DTO pattern
* Exception handling
* Request validation
* MySQL database integration
* Aspect-Oriented Programming (AOP)
* Unit testing
* Controller testing
* Integration testing
* Code coverage with JaCoCo

## Project Structure

```text
controller
service
repository
entity
dto
mapper
exception
aspect
integration tests
```

## Database Configuration

The application uses MySQL as the database.

Database connection details are configured through application properties and should be provided according to the local environment.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=<username>
spring.datasource.password=<password>
```

## Running the Application

### Clone the repository

```bash
git clone <repository-url>
```

### Start MySQL using Docker

Create a MySQL container with your own database credentials:

```bash
docker run --name mysql-docker \
-e MYSQL_ROOT_PASSWORD=<your-password> \
-e MYSQL_DATABASE=librarydb \
-p 3306:3306 \
-d mysql
```

### Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## Testing

The project includes automated tests for the application's main layers.

Completed testing includes:

* Controller tests
* Mapper tests
* Integration tests

Service-layer unit tests are the remaining tests to be completed.

Run the existing tests with:

```bash
./mvnw clean test
```

## Code Coverage

JaCoCo is configured to generate test coverage reports.

Generate the report:

```bash
./mvnw clean test
```

The report can be found at:

```text
target/site/jacoco/index.html
```

## Aspect-Oriented Programming

Spring AOP is used to separate cross-cutting concerns from the main application logic.

The project includes an `aspect` layer for handling concerns that can be applied across multiple parts of the application.

## API Endpoints

Example book endpoints:

```text
GET    /api/v1/books
POST   /api/v1/books
PUT    /api/v1/books/{id}
DELETE /api/v1/books/{id}
```

## Author

Sadaf Jabbar
1/books
POST   /api/v1/books
PUT    /api/v1/books/{id}
DELETE /api/v1/books/{id}
```
## Author
Sadaf Jabbar
