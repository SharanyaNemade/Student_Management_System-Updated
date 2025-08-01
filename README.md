# Student_Management_System-Updated


# 🎓 Student Management System

Student Management System is a full-stack web application developed using Spring Boot, Thymeleaf, and Spring Security, designed to manage student data efficiently. It provides a secure login mechanism and complete CRUD (Create, Read, Update, Delete) functionality for managing student records. The application follows a layered architecture with distinct packages for controllers, services, repositories, and entities. Users can log in, view all students, add new students, update existing records, and delete students through a clean web interface. Data is persisted using Spring Data JPA and stored in a relational database (H2 or MySQL).


---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Security**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 / MySQL**
- **Maven**

---

## ✨ Features

- 🔐 **Secure Login** using Spring Security
- ➕ **Create** new student records
- 📋 **Read** and list all student records
- ✏️ **Update** existing student details
- ❌ **Delete** students from the system
- 📄 Web-based views using **Thymeleaf templates**
- 🧩 Layered architecture with clean separation of concerns
- 🔎 Optional **Swagger** integration for REST API documentation

---

## 📁 Project Structure





src
├── main
│ ├── java
│ │ └── com.example
│ │ ├── config # Swagger and app configs
│ │ ├── controller # Login and Student controllers
│ │ ├── entity # Student.java (Entity class)
│ │ ├── repository # StudentRepository interface
│ │ ├── security # SecurityConfig.java
│ │ ├── service # StudentService & implementation
│ │ └── StudentManagementSystemApplication.java
│ └── resources
│ ├── static # Static assets (CSS, JS)
│ ├── templates # Thymeleaf views:
│ │ ├── login.html
│ │ ├── students.html # List students
│ │ ├── create_student.html # Add student
│ │ └── edit_student.html # Edit student
│ └── application.properties







---

## 🚀 Getting Started

### Prerequisites

- Java 17
- Maven

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/student-management-system.git




2. Navigate to the project folder:
    cd student-management-system



3. Build the project:
    mvn clean install



4. Run the application:
  mvn spring-boot:run


Open your browser and navigate to:
http://localhost:8080/login






🔐 Default Login Credentials
To be configured in SecurityConfig.java.

Example:

Username: admin
Password: admin123




🧪 CRUD Operations Overview
Operation	Endpoint	Description
Create	/students/new	Shows form to add a new student
Read	/students	Displays list of all students
Update	/students/edit/{id}	Shows form to update a student
Delete	/students/{id}	Deletes a student by ID



🔐 Security
All student management operations are secured.
Only authenticated users can access CRUD functionalities.
Configuration is handled via SecurityConfig.java.



🧩 Future Enhancements
Pagination and search
Role-based access control (Admin/User)
REST API with Swagger UI
Database switch to MySQL/PostgreSQL



📃 License
This project is licensed under the MIT License - see the LICENSE file for details.



🙌 Acknowledgments
Spring Boot Documentation
Thymeleaf Guides
Baeldung Tutorials

