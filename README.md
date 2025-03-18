# Traini8 Backend Project

This is a Spring Boot application designed to manage government-funded training centers. It provides REST APIs to create and retrieve training centers, with support for filtering and validation.

---

## Features Implemented

### 1. Create a New Training Center

#### Validation
- **centerName:** Mandatory, less than 40 characters.
- **centerCode:** Mandatory, exactly 12 alphanumeric characters.
- **contactEmail:** Optional, must be a valid email format.
- **contactPhone:** Mandatory, must be a 10-digit number.

**Response:** Returns the newly created training center in JSON format.

### 2. Retrieve All Training Centers

- **API Endpoint:** `GET /api/training-centers`  
- **Description:** Retrieves a list of all training centers stored in the database.
- **Query Parameters (Optional):**
  - **city:** Filters training centers by city.
  - **state:** Filters training centers by state.
  - **coursesOffered:** Filters training centers by courses offered (supports multiple values).
- **Response:** Returns a list of training centers in JSON format.

### 3. Filter Training Centers

- **API Endpoint:**  
  `GET /api/training-centers?city=Mumbai&state=Maharashtra&coursesOffered=Java`
- **Description:** Filters training centers based on city, state, and coursesOffered.
- **Example Requests:**
  - **Filter by city:** `GET /api/training-centers?city=Mumbai`
  - **Filter by state:** `GET /api/training-centers?state=Maharashtra`
  - **Filter by courses offered:** `GET /api/training-centers?coursesOffered=Java&coursesOffered=Spring Boot`
- **Response:** Returns a filtered list of training centers in JSON format.

### 4. Validation and Error Handling

- **Validation:** Implemented using Bean Validation annotations (`@NotBlank`, `@Size`, `@Email`, `@Pattern`).
- **Error Handling:** Uses a `GlobalExceptionHandler` to return meaningful error messages in JSON format for validation failures.

**Example Error Response:**
```json
{
  "centerName": "CenterName must be less than 40 characters",
  "centerCode": "CenterCode must be exactly 12 characters",
  "contactEmail": "Invalid email format",
  "contactPhone": "ContactPhone must be a 10-digit number"
}
```

### Technologies Used

    Backend Framework: Spring Boot
    Database: MongoDB Atlas (with Spring Data MongoDB)
    Build Tool: Maven
    Validation: Bean Validation (Hibernate Validator)
    Exception Handling: Spring Boot @RestControllerAdvice

## Setup Instructions
### Prerequisites

    Java JDK 17: Install from Oracle JDK or OpenJDK.
    Maven: Install from Maven Download.
    MongoDB: MongoDB Atlas for cloud-based storage.

## Steps to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/trainingi8-backend.git
cd trainingi8-backend
```
### 2. Configure MongoDB

Create a .env file at the root of the project and obtain a MongoDB connection string from MongoDB Atlas and paste it in the .env file as follows:
```bash
MONGODB_URI=mongodb+srv://<username>:<password>@cluster0.xop3g.mongodb.net/trainingi8db?retryWrites=true&w=majority&appName=Cluster0
```

### 3. Build the Project

```bash

mvn clean install
```

### 4. Run the Application

```bash

mvn spring-boot:run
```

### 5. Access the APIs

    The application will be running at http://localhost:8080.
    Use Postman or cURL to test the APIs.

