# Products API

## Table of Contents
1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [User Access and Roles](#user-access-and-roles)
5. [Application Functionalities](#application-functionalities)
6. [Swagger Documentation](#swagger-documentation)

---

## Overview

The Products API is a Spring Boot application that provides functionalities for managing products and categories. It supports operations such as viewing, creating, editing, and deleting products, with user roles determining access levels.

---

## Prerequisites

Ensure you have the following installed:

- **Java** (JDK 17 or later)
- **Maven**
- **Docker** and **Docker Compose**

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>
```

### 2. Start the Database
   Use Docker Compose to start the PostgreSQL database:

```bash
docker-compose up -d
```
This command starts a PostgreSQL instance with the configuration provided in the docker-compose.yml file.

### 3. Run the Application
   Use the Spring Boot CLI or Maven to start the application.

#### Using Spring Boot CLI:
```bash
spring run src/main/java/com/qima/productsapi/ProductsApiApplication.java
```
Using Maven:
```bash
mvn spring-boot:run
```
The application will start on http://localhost:8082.

### User Access and Roles
#### Admin User
- Username: admin 
- Password: admin 
- Role: ADMIN 
- Permissions: Can view, create, edit, and delete products.

#### Regular User
- Username: user
- Password: user
- Role: USER
- Permissions: Can only view products.

### Application Functionalities
1. Login

- URL: http://localhost:8082/login
Admin and regular users can log in with their respective credentials.
2. View Products

- Both roles can view the list of products.
- Includes product details like name, description, price, availability, and category path.

3. Create New Product

- Admin Only
- Accessible via the "New Product" button on the product list page.

4. Edit Product

- Admin Only
- Accessible via the "Edit" button for each product in the list.

5. Delete Product

Admin Only
Accessible via the "Delete" button (trash icon) for each product in the list.

6. Logout

- A "Logout" button is available to end the session and redirect to the login page.
Swagger Documentation
The API is fully documented with Swagger for easy exploration and testing.

### Access Swagger UI
URL: http://localhost:8082/swagger-ui.html

#### Features of Swagger

- Explore all endpoints.
- Test endpoints directly from the browser.
- View detailed request/response information.

### Helpful Commands
#### Stop Docker Containers
```bash
docker-compose down
```
#### Rebuild the Application
```bash
mvn clean install
```
### Support
For questions or issues, please contact the repository maintainer at fernando.lerma@gmail.com