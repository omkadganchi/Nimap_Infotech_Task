Nimap Infotech Task - Category and Product Management System
Introduction 
Welcome to the Nimap Infotech Task repository. This project is a Category and Product Management System built using Spring Boot. It allows for the management of categories and products, supporting CRUD operations, a one-to-many relationship between categories and products, server-side pagination, and detailed responses for products that include their associated category.

Project Overview
The application provides functionality for managing categories and products, including the ability to perform the following:

CRUD Operations on categories and products.
Establishment of a one-to-many relationship between categories and products (one category can have many products).
Support for server-side pagination to manage large datasets efficiently.
Detailed product responses that include the category it belongs to.
Tech Stack
Java 21
Spring Boot 2.5.6
Spring Data JPA
Hibernate 
MySQL 
Postman 

Prerequisites
Java 21 or later installed.
Maven 2.x installed.
MySQL 8.x or another RDBMS (H2 is used for local development by default).
Postman for API testing.
Features Implemented
Category CRUD Operations
GET /api/categories?page={page_number}: Get all categories with pagination.
POST /api/categories: Create a new category.
GET /api/categories/{id}: Get a category by its ID.
PUT /api/categories/{id}: Update an existing category by ID.
DELETE /api/categories/{id}: Delete a category by ID.
Product CRUD Operations
GET /api/products?page={page_number}: Get all products with pagination.
POST /api/products: Create a new product.
GET /api/products/{id}: Get a product by ID.
PUT /api/products/{id}: Update an existing product by ID.
DELETE /api/products/{id}: Delete a product by ID.
One-to-Many Relationship Between Category and Product
A category can have multiple products. This relationship is managed via JPA and Hibernate.
Pagination
Server-side pagination is implemented for fetching categories and products to efficiently manage large datasets.
Category Details in Product Response
When retrieving a product by its ID, the product details include the category it belongs to.
Project Structure
Controller Layer:
Handles HTTP requests and responses for categories and products.
Uses annotations like @RestController and @RequestMapping to define endpoints.
Service Layer:
Implements business logic for categories and products.
Coordinates interactions between the controller and the data access layer.
DAO (Data Access Object) Layer:
Uses Spring Data JPA to handle database operations and CRUD actions with Hibernate.
