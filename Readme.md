# 🏫 Smart Campus Issue Management System

A **full-stack web application** designed to manage and resolve campus-related issues in a **secure, role-based, and structured manner**.

This project simulates a real-world campus workflow where students raise issues, admins assign them, and staff resolve them — all backed by **JWT authentication and role-based access control**.

---

## 📌 Project Overview
In many campuses, infrastructure issues (classrooms, hostels, labs, etc.) are reported informally, leading to:
- Lack of tracking
- No accountability
- Delayed resolution

The **Smart Campus Issue Management System** solves this by providing a **centralized and secure platform** for reporting, assigning, and resolving campus-related issues.

---

## 👥 User Roles & Responsibilities

### 🎓 Student
- Login securely
- Raise campus-related issues
- View issues raised by them and their current status

### 🧑‍💼 Admin
- View all reported issues
- Assign issues to appropriate staff members

### 🛠 Staff
- View issues assigned to them
- Update issue status (In Progress / Resolved)

---

## 🔐 Authentication & Security

- **JWT-based stateless authentication**
- **Spring Security** for authentication and authorization
- Role information embedded inside JWT
- Backend derives user identity from JWT  
  ❌ No userId is passed from frontend (security best practice)

---

## ⚙️ Core Features

✔ Secure login using email & password  
✔ Role-based dashboards (Student / Admin / Staff)  
✔ Issue creation, assignment, and status updates  
✔ Protected routes and APIs  
✔ Clean layered architecture (Controller → Service → Repository)  

---

## 🛠 Tech Stack

### 🌐 Frontend
- React (Vite)
- Tailwind CSS
- Axios
- React Router DOM

### ⚙️ Backend
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA

### 🗄 Database
- MySQL

### 🔧 Tools
- Git & GitHub
- Postman
- IntelliJ IDEA
- VS Code

---

## 🏗 Architecture Overview


- Stateless backend
- Secure API design
- Clear separation of concerns

---

## 🔗 Repositories

- 🔙 **Backend Repository**  
  https://github.com/Sarthak-7558/SmartCampus-Backend  

- 🌐 **Frontend Repository**  
  https://github.com/Sarthak-7558/SmartCampus-Frontend  

---

## 🚀 Deployment Status

- Backend: In progress (Render)
- Database: In progress (Railway)
- Frontend: In progress (Vercel)

---

## 📈 Future Enhancements

- Pagination and filtering of issues
- Email notifications
- Status history tracking
- Image uploads for issues
- Docker-based deployment

---

## 📌 Notes
- User registration is currently handled by admin/system setup.
- This approach avoids unauthorized role creation and follows enterprise security practices.
- Can be extended with public registration and email verification in future versions.

---

## 🙌 Learning Outcomes
- Hands-on experience with Spring Security and JWT
- Secure REST API design
- Role-based access control
- Full-stack integration
- Real-world system architecture understanding

---
Built as part of a **Full Stack Development learning project**.
