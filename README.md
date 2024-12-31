# <div align="center"> Employee Management using Spring Security </div>
   ##   Description
  *-> A robust Employee Management API built with Spring Boot and Java, designed to manage employee records securely and efficiently. This application features seamless CRUD operations, comprehensive employee data management, role-based access control with Spring Security, and RESTful endpoints. Leveraging JPA/Hibernate for database interactions and MySQL for data persistence, it provides a scalable and secure solution for managing employee information.*
  
  ## Features
- **Authentication & Authorization::** Secure access to endpoints using JWT (JSON Web Token) to ensure only authorized users can perform actions.
- **Employee Management:** Create, retrieve, and delete employee records with detailed information, ensuring seamless data handling.
- **Token-Based Authentication:**  Automatically generate a token during employee creation for enhanced security.
- **Data Retrieval:** Fetch employee details based on token-authenticated requests.
- **Record Deletion:** Delete employee records securely with validation through token-based authentication.
- **Error Handling:** Comprehensive error responses for cases like duplicate data, unauthorized access, or record not found.
- **Swagger Integration:** Easily explore and test API endpoints with detailed documentation and sample responses.
- **Spring Security Integration:** Leverages Spring Security for endpoint protection and request validation.

## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Security:** Spring Security
- **Build Tool:** Maven
- **ORM:** Hibernate (JPA)
- **Dependency Management:** Lombok
- **Testing:** JUnit 5, Spring Boot Test
- **API Documentation:** Swagger UI (for interactive API documentation and testing)
- **Version Control:** Git

## Getting Started
### 1) Prerequisites
1. **Java:**  Ensure that JDK 11 or later is installed. You can download it from the Oracle website or use OpenJDK.
2. **Maven:** Ensure Maven is installed to build the project. You can download it from the [Apache Maven website](https://maven.apache.org/download.cgi).
3. **MySQL:** Install MySQL for managing the database. You can download it from the [MySQL website](https://dev.mysql.com/downloads/installer/). Create a database for the application.
4. **IDE:** A Java Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or VSCode can help you manage and run the project efficiently.
5. **Swagger UI:** Ensure that Swagger UI is integrated with your Spring Boot application for interactive API documentation. You can access it via the URL provided when the application is running.
### 2) Setup
1. **Clone the Repository:**
   
    ```bash
      git clone https://github.com/RudraPrasad07/EmployeeManagementAPI.git
    ```
2. **Navigate to the Project Directory:**
   
    ```bash
    cd EmployeeManagementAPI
    ```
3. **Configure Database:**
   
   Update `src/main/resources/application.properties` with your MySQL database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
4. **Build the Project:**
   
    ```bash
    mvn clean install
    ```
5. **Run the Application:**
   
    ```bash
    mvn spring-boot:run
    ```
6. **Access Swagger UI:**  Once the application is running, you can access the Swagger UI documentation on your browser with the URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   
### 3) Running the Application
Once the application is up and running, you can access the REST API through the following endpoints:

#### Employee Controller
- **/Employee/saveEmployee:** his endpoint allows for the creation of a new employee record. It saves the Employee object and generates a JWT token for the employee's name. The token is returned in the response for future authentication.
- **/Employee/getEmployee:**  This endpoint retrieves the data of an employee based on the JWT token provided in the request header (Authorization). The token's username is extracted to fetch the employee's details.
- **/Employee/delete:**  This endpoint deletes an employee record from the database based on the JWT token provided in the request header (Authorization). The username is extracted from the token to identify the employee to delete.
   
### 4) API Documentation
You can explore and test the APIs using Swagger (if integrated) or tools like Postman. Below is an example of a sample API request in Postman:
### Sample API Request
- **Method**: POST
- **URL**: `http://localhost:8080/Employee/saveEmployee`

- **Body**:
```json
{
    "name": "Name",
    "dob": "DOB",
    "gender": "Gender",
    "email": "Email",
    "age": "age",
    "number": "PhoneNumber",
    "dob":"dob",
    "gender":"gender"
}
```
### 5) Database Configuration
### Switching to MySQL

To use MySQL, update the `application.properties` file with the following configuration:

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 6) Testing
 - **Run tests using the following Maven command:**
    ```bash
    mvn test
    ```
    
###  ***Contributing***
   *Feel free to contribute or provide feedback. Your support is greatly appreciated!*

</br>
  <div align="center">

 ***Thank You! For checking out my project! 🙏***



</div>
