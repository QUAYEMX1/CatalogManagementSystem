# Catalog Management System

The Catalog Management System is a Spring Boot-based REST API application designed to manage products. The system supports operations such as adding, retrieving, updating, and deleting products, and allows users to filter products by brand or category.

---

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Request/Response Examples](#requestresponse-examples)
- [Dependencies](#dependencies)
- [Author](#author)

---

## Features
- Add new products to the catalog.
- Retrieve product
- Update product details by product name.
- Delete a product from the catalog by ID.
- Logs for tracking API calls and debugging.
- Validations and custom exception handling for better error management.

---

## Tech Stack
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Build Tool**: Maven
- **ORM**: Hibernate (JPA)
- **Logging**: SLF4J with Logback

---

## Setup Instructions

### Prerequisites
1. **Java**: Ensure Java 17 or higher is installed.
2. **Maven**: Install Maven for building the project.
3. **MySQL**: Set up a MySQL database.

### Steps
1. Clone the repository:
   ```bash
   git clone [https://github.com/your-repository/catalog-management-system.git](https://github.com/QUAYEMX1/CatalogManagementSystem.git)
   cd catalog-management-system

