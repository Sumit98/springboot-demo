# springboot-demo
Demo Project utilizing basic Springboot features

REST API for CRUD Operations with Student Details.

A RESTful API created using Spring Boot. I have used PostgreSQL as the relational database and JdbcTemplate to interact with that.

## Setup and Installation

1. **Clone the repo from GitHub**
   ```sh
   git clone https://github.com/Sumit98/springboot-demo.git
   cd demo
   ```
2. **(Optional) Update database configurations in application.properties**
   
   If your database is hosted at some cloud platform or if you have modified the SQL script file with some different username and password, update the src/main/resources/application.properties file accordingly:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student
   spring.datasource.username=
   spring.datasource.password=
   ```
3. **Run the spring boot application**
   ```sh
   ./mvnw spring-boot:run
   ```
   This runs at port 8080 and hence all enpoints can be accessed starting from http://localhost:8080
