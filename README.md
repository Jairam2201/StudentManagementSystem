# Student Management System

A simple **Java console-based application** to manage student records with **CRUD operations** (Create, Read, Update, Delete) using **JDBC** and a **MySQL database**.

---

## Table of Contents

- [Features](#features)  
- [Technologies Used](#technologies-used)  
- [Database Setup](#database-setup)  

---

## Features

- Add new student records  
- View all students in the database  
- Update student details selectively (one field at a time)  
- Delete a student by ID  
- Handles invalid input and non-existent records gracefully  
- Simple, intuitive console interface  

---

## Technologies Used

- **Java 17+**  
- **MySQL** (or any JDBC-compatible database)  
- **JDBC** for database connectivity  

---

## Database Setup

1. Create a database, e.g., `studentdb`.
2. Create a `students` table:

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    dateofbirth DATE NOT NULL,
    place VARCHAR(100),
    age INT,
    course VARCHAR(50),
    branch VARCHAR(50)
);
