# Bookstore 📚

Bookstore is a web-based application for managing a personal book collection, built using **Spring Boot**. 
The system allows users to securely store, organize, and manage their favorite books in a private library.

---

## 1. How to Run the Application
Run the Project:

    In Eclipse, right-click on the project root -> Run As -> Spring Boot App.

    The application will start on: http://localhost:8080.
    
## 2. Database Configuration:

    Open your MySQL terminal or Workbench and create the database:
    SQL

CREATE DATABASE mybooksdb;

Open src/main/resources/application.properties in Eclipse.

Update spring.datasource.username and spring.datasource.password with your MySQL credentials.

## 3. Features and Usage

The application provides a complete environment for book enthusiasts with the following functionalities:

    Secure Authentication: Users can sign in using a standard registration/login form or via Google OAuth2 (Social Login).

    Personal Library View: The Home page is filtered dynamically. Users see only the books they have personally added.

    Book Management (CRUD): * Add: Easily add new books with Title, Author, Description, and a Cover Image URL.

        Edit: Update details of existing books in your collection.

        Delete: Remove books from your library with a confirmation prompt.

    Ownership Protection: Edit and Delete buttons are only visible to the owner of the book, ensuring data integrity.

    Dynamic UI: The navigation bar greets the logged-in user by their registered name or Google profile name.

## 4. 3. Public CodeSandbox Link

 https://codesandbox.io/p/github/vladibojhkov/Bookstore

 

Follow these steps to get the project up and running on your local machine:

### Prerequisites
* **Java JDK 17** or higher
* **Maven** (integrated in Eclipse)
* **MySQL Server**

### Setup Steps
1. **Clone the Repository:**
   ```bash
   git clone (https://codesandbox.io/p/github/vladi33/Bookstore?branch=master)
   
