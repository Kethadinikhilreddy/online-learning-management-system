# 📚 Online Learning Management System

A full-stack Java-based web application that enables students and instructors to manage online learning efficiently. The system is built using JSP, Servlets, Hibernate (Many-to-Many Bidirectional Mapping), and MySQL, following the MVC architecture.

## 🚀 Features
### 👤 User Management

* Student and Instructor registration & login

* Role-based authentication using HTTP sessions

* Secure logout functionality

### 📘 Course Management

* Instructors can create and manage courses

* Students can view available courses

* Students can enroll in multiple courses

### 🔁 Many-to-Many Relationship

* Bidirectional Many-to-Many mapping between Student and Course

* Managed using Hibernate annotations

* Join table handles enrollments efficiently

### 🏗 Architecture

* MVC pattern for separation of concerns

* DAO layer for database operations

* Hibernate ORM for persistence

* JSP for dynamic UI rendering

## 🛠 Tech Stack

| Layer           | Technologies   |
| --------------- | -------------- |
| Backend         | Java, Servlets |
| Frontend        | JSP, HTML, CSS |
| ORM             | Hibernate      |
| Database        | MySQL          |
| Server          | Apache Tomcat  |
| Build Tool      | Maven          |
| Version Control | Git & GitHub   |


## 🧩 Project Structure

```
Online-Learning-Management-System
│
├── src/main/java
│   ├── org.controller     → Servlets (Controllers)
│   ├── org.dao            → DAO layer
│   ├── org.dto            → Entity classes
│   └── org.util           → Hibernate utility
│
├── src/main/webapp
│   ├── *.jsp              → JSP views
│   ├── css/               → Stylesheets
│   └── WEB-INF
│       └── web.xml
│
├── pom.xml
└── README.md 

```
## 🔗 Hibernate Mapping (Core Highlight)

Student ↔ Course (Many-to-Many, Bidirectional)
```
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```

- Both entities maintain references

- Join table handles enrollment

- Efficient data fetching using Hibernate sessions

## ⚙️ How to Run the Project
### 1️⃣ Prerequisites

* Java 8+

* MySQL

* Apache Tomcat 9+

* Maven

* IDE (Eclipse / IntelliJ)

### 2️⃣ Database Setup
* CREATE DATABASE online_learning_db;


* Update DB credentials in hibernate.cfg.xml:
```
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/online_learning_db
</property>
```
### 3️⃣ Run the Project

* Import project as Maven Project

* Configure Tomcat Server

* Run on server

* Open browser:
```
http://localhost:8080/online-learning-management-system
```
## 🎯 Learning Outcomes

* Hands-on experience with Hibernate ORM

* Practical implementation of Many-to-Many bidirectional mapping

* Understanding of MVC architecture

* Session handling and authentication in Servlets

* Real-world CRUD operations

⭐ If you like this project, give it a ⭐ on GitHub — it helps a lot!
