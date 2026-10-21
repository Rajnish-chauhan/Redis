# Spring Boot Redis User API

This is a simple Spring Boot REST API for managing users, backed by Redis for storage. It provides standard CRUD (Create, Read, Update, Delete) operations.

## Base URL

All endpoints are relative to the base path: `/users/`
*(Note: Based on `@RequestMapping("/users/**")`)*

## API Endpoints

### 1. Create a User

Creates a new user and automatically generates a unique UUID for the `userId`.

* **URL:** `/users/create`
* **Method:** `POST`
* **Request Body:** (JSON)
  ```json
  {
    "name": "John Doe",
    "phone": "123456",
    "email": "john.doe@example.com"
  }
  ```
* **Success Response:** Returns the created `User` object with the generated `userId`.

### 2. Get a User by ID

Retrieves a specific user based on their unique `userId`.

* **URL:** `/users/getUser/{userId}`
* **Method:** `GET`
* **URL Params:**
    * `userId=[String]` (Required)
* **Success Response:** Returns the `User` object.

### 3. Get All Users

Retrieves a list of all users stored in the Redis database.

* **URL:** `/users/getAllusers`
* **Method:** `GET`
* **Success Response:** Returns a JSON array of `User` objects.

### 4. Delete a User

Deletes a specific user based on their unique `userId`.

* **URL:** `/users/delete/{userId}`
* **Method:** `DELETE`
* **URL Params:**
    * `userId=[String]` (Required)
* **Success Response:** HTTP Status `200 OK` (No content returned).

## Technology Stack

* Java 21+
* Spring Boot
* Spring Data Redis