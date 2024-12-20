# ECommerce

ECommerce is a simple RESTful API using Spring Boot. It allows for User login and viewing categories.

---

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [UML Diagram](#uml-diagram)

---

## Requirements

- [Git](https://git-scm.com/downloads)
- [Java 21](https://www.oracle.com/th/java/technologies/downloads/) or Higher
- [MySQL](https://www.mysql.com/) 8.0 or higher
- [Maven](https://maven.apache.org/) for dependency management
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Spring Boot](https://spring.io/projects/spring-boot) 2.7.3
- [Postman](https://www.postman.com/downloads/) for testing

---

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/sameem-saleem/ECommerce.git
   cd ECommerce
   ```
   
2. Run `create_database.sql` in API/database.

3. Run the application

---

## Features
- User Authentication
  - Register and login using username/password.
  - Secure endpoints with JWT authentication token.
---

## UML Diagram
![UML Diagram](https://github.com/joe-bor/easyShop/raw/main/README-images/uml.png)

---

## API Endpoints
[//]: # (Auth)
<details>
  <summary><strong>Authentication</strong></summary>
     <ul>
         <li><code>POST /register</code>: Register a new user.</li>
         <li><code>POST /login</code>: Authenticate and retrieve JWT.</li>
     </ul>
 </details>
 
[//]: # (Categories)
 <details>
     <summary><strong>Categories</strong></summary>
     <ul>
         <li><code>GET /categories</code>: List all categories.</li>
         <li><code>POST /categories</code>: Add a new category.</li>
         <li><code>PUT /categories</code>: Update a category.</li>
         <li><code>DELETE /categories/{id}</code>: Delete a category.</li>
     </ul>
 </details>

