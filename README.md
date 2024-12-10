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
4. **version**:3.4.0

### Steps
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/QUAYEMX1/CatalogManagementSystem.git
    cd CatalogManagementSystem
    ```
---
### API Endpoints

#### 1. **Add a New Product**
- **Endpoint**: `/Product/Api/addProduct`
- **Method**: `POST`
- **Description**: Adds a new product to the catalog.
- **Request Body**: 
  ```json
  {
    "name": "Product Name",
    "category": "Category Enum",
    "brand": "Brand Name",
    "price": "Product Price",
    "quantity": "Product Quantity"
  }


#### 2. **Get Product By Id**
- **Endpoint**: `/Product/Api/getProduct`
- **Method**: `GET`
- **Description**:Retrieves a product by its ID.
- **Response Body**: 
  ```json
  {
  "id": "Product ID",
  "name": "Product Name",
  "category": "Category Enum",
  "brand": "Brand Name",
  "price": "Product Price",
    "quantity": "Product Quantity"
}

#### 3. **Get Products by Brand**
- **Endpoint**: `/Product/Api/getProductByBrand`
- **Method**: `GET`
- **Description**:Retrieves products by brand name.
- **Response**: 
  ```json
  [
  {
    "id": "Product ID",
    "name": "Product Name",
    "category": "Category Enum",
    "brand": "Brand Name",
    "price": "Product Price",
    "quantity": "Product Quantity"
  }
  ]

#### 4. **Get Products by Category**
- **Endpoint**: `/Product/Api/getProductByCategory`
- **Method**: `GET`
- **Description**:Retrieves products by category.
- **Response**:
  ```json
  [
  {
    "id": "Product ID",
    "name": "Product Name",
    "category": "Category Enum",
    "brand": "Brand Name",
    "price": "Product Price",
    "quantity": "Product Quantity"
  }
]

#### 5. **Update Product by ID**
- **Endpoint**: `/Product/Api/updateById`
- **Method**: `PUT`
- **Description**: Updates a product by its ID.
- **Request Body**:
  ```json
  {
    "name": "Updated Product Name",
    "category": "Updated Category Enum",
    "brand": "Updated Brand Name",
    "price": "Updated Product Price",
    "quantity": "Updated Product Quantity"
  }

- **Response**:
   ```json
{
  "message": "Product updated successfully"
}


#### 6. **Update Product by Name**
- **Endpoint**: `/Product/Api/updateByName`
- **Method**: `PUT`
- **Description**: Updates a product by its name.

- **Request Body**:
  ```json
  {
    "name": "Updated Product Name",
    "category": "Updated Category Enum",
    "brand": "Updated Brand Name",
    "price": "Updated Product Price",
    "quantity": "Updated Product Quantity"
  }

- **Response**:
   ```json
{
  "message": "Product updated successfully"
}

#### 7. **Delete Product by ID**
- **Endpoint**: `/Product/Api/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a product from the catalog by its ID.

- **Response**:
  ```json
  {
    "message": "Product deleted successfully"
  }









  





  








