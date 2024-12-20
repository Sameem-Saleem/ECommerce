# EasyShop API

EasyShop is a RESTful API designed to handle user authentication, profile management, and e-commerce features like product browsing, category management, cart operations, and order processing. It uses Spring Boot and integrates modern technologies such as JWT, and OAuth2 for GitHub authentication.

[Link to GitHub Project](#)

---

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [How It Works](#how-it-works)
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
   
2. Run `create_database.sql`, located in `/backend/database/`, to create and seed the database.

3. Run the application

---

## How It Works

[//]: # (![]&#40;&#41;)

- **Authentication**: Supports JWT-based authentication to protect resources and GitHub OAuth2 for login.
- **E-commerce Frontend**: Provides a clean interface to view API functionality.

---

## Features
- User Authentication
  - Register and login using username/password or GitHub Oauth2.
  - Secure endpoints with JWT.
---

## UML Diagram
![UML Diagram](https://github.com/joe-bor/easyShop/raw/main/README-images/uml.png)

---

## API Endpoints

---