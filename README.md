# Library Management API

A RESTful Library Management API built using Spring Boot.  
The application manages books, categories, users, and loans with MySQL database integration.

## Technologies Used

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA / Hibernate
- MySQL
- Docker
- Maven
- JUnit 5
- Mockito
- JaCoCo

## Features

- Manage books
- Manage categories
- Manage users
- Manage loans
- CRUD operations
- DTO pattern
- Exception handling
- Validation
- MySQL database integration
- Unit testing
- Controller testing
- Integration testing
- Code coverage with JaCoCo

## Project Structure

```
controller
service
repository
entity
dto
mapper
exception
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

```
http://localhost:8080
```

## Testing

Run all tests:

```bash
./mvnw clean test
```

The project includes:

- Unit tests
- Controller tests
- Integration tests

## Code Coverage

JaCoCo is configured to generate test coverage reports.

Generate the report:

```bash
./mvnw clean test
```

The report can be found at:

```
target/site/jacoco/index.html
```

## API Endpoints

Example endpoints:

```
GET    /api/v1/books
POST   /api/v1/books
PUT    /api/v1/books/{id}
DELETE /api/v1/books/{id}
```
## Author
Sadaf Jabbar