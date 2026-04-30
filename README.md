# Bookstore 📚

Bookstore is a web-based application for manage a personal book collection, built using Spring Boot. 
The system allows users to securely store, organize, and manage their favorite books in a library.

---

## 1. How to launch the Application
   Project launch:

    In Eclipse, right-click on the project -> Run As -> Spring Boot App.

    The application will launched on: http://localhost:8080.
    
## 2. Database Configuration:

    Open your MySQL terminal or Workbench and create the database:
    SQL

CREATE DATABASE mybooksdb;

Open src/main/resources/application.properties in Eclipse.

Update spring.datasource.username and spring.datasource.password with your MySQL identification data.

## 3. Functions and use

The app provide an environment for book lovers with the following features:

    Secure Authentication: Users can log in using a standard registration/login form or Google OAuth2 (Social Login).

    Personal Library design: The Home page is filtered dynamically. Users only see books they have personally added.

    Book Management (CRUD):
        
        Create: Easily add new books with Title, Author, Description, and Cover Image URL address.

        Read: Read new books with title, author, description and cover image URL address.

        Update: Update details of existing books in your collection.

        Delete: Remove books from your library with a confirmation prompt.

    Protecting my books in the library: The edit and delete buttons are only visible to the book owner, which ensures all data in my library.

    Dynamic user interface: The navigation bar greets the logged-in user with their registered name or Google profile name.

### Necessary requirements
* **Java JDK 17** or higher
* **Maven** (integrated in Eclipse)
* **MySQL Server**

## 4. Public CodeSandbox Link

 [**Bookstore on CodeSandbox**] (https://codesandbox.io/p/github/vladi33/Bookstore?branch=master)
   
