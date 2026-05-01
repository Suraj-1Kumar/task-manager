# 🗂️ TaskFlow — Team Task Manager

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=for-the-badge&logo=docker)
![Railway](https://img.shields.io/badge/Deployed_on-Railway-black?style=for-the-badge&logo=railway)

A full-stack **Team Task Management** application with **Role-Based Access Control**,
built with Spring Boot + PostgreSQL backend and a Vanilla JS frontend.

[🌐 Live Frontend](https://suraj-1kumar.github.io/task-manager/) • [⚙️ Live API](https://task-manager-production-dc85.up.railway.app/actuator/health) • [📁 Source Code](https://github.com/Suraj-1Kumar/task-manager)

</div>

---

## 🚀 Live URLs

| Service | URL |
|---|---|
| 🌐 Frontend | https://suraj-1kumar.github.io/task-manager/ |
| ⚙️ Backend API | https://task-manager-production-dc85.up.railway.app |
| 🏥 Health Check | https://task-manager-production-dc85.up.railway.app/actuator/health |

---

## 🔐 Test Credentials

| Role | Username | Password |
|---|---|---|
| 👑 Admin | `suraj_admin` | `your-password` |
| 👤 Member | `member1` | `your-password` |

> Admin has full access. Member can only view and update task status.

---

## ✨ Features

### Authentication
- [x] User Signup with role selection (Admin / Member)
- [x] User Login returning JWT token
- [x] Stateless session — no cookies
- [x] BCrypt password hashing

### Project Management
- [x] Create, update, delete projects
- [x] View all projects
- [x] Admin-only delete protection

### Task Management
- [x] Create tasks with title, description, due date
- [x] Assign tasks to team members by username
- [x] Update task status — `TODO` / `IN_PROGRESS` / `DONE`
- [x] Automatic overdue detection
- [x] Admin-only delete protection

### Dashboard
- [x] Total projects count
- [x] Total tasks count
- [x] In-progress tasks count
- [x] Completed tasks count
- [x] Overdue tasks count
- [x] Recent tasks list

### Role-Based Access Control (RBAC)
- [x] Admin — full access to all features
- [x] Member — view and update task status only
- [x] Members tab visible to Admin only
- [x] Delete buttons visible to Admin only

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Java 21 | Core language |
| Spring Boot 3 | Application framework |
| Spring Security | Authentication & authorization |
| JWT (jjwt 0.11.5) | Stateless token authentication |
| Spring Data JPA | Database ORM |
| Hibernate | JPA implementation |
| PostgreSQL | Relational database |
| Maven | Build tool |
| Docker | Containerization |
| Lombok | Boilerplate reduction |
| Spring Actuator | Health check endpoint |

### Frontend
| Technology | Purpose |
|---|---|
| HTML5 | Structure |
| CSS3 | Styling (dark theme) |
| Vanilla JavaScript | Logic & API calls |
| Fetch API | REST API communication |
| localStorage | JWT token persistence |

### DevOps
| Technology | Purpose |
|---|---|
| Railway | Backend + Database hosting |
| GitHub Pages | Frontend hosting |
| Docker | Container build & deploy |

---

## 🏗️ Architecture

```
┌──────────────────────────────────┐
│   Frontend — GitHub Pages        │
│   (HTML + CSS + Vanilla JS)      │
│   suraj-1kumar.github.io         │
└───────────────┬──────────────────┘
                │ HTTPS REST API calls
                │ Authorization: Bearer <JWT>
┌───────────────▼──────────────────┐
│   Backend — Railway              │
│   Spring Boot 3 + Java 21        │
│   task-manager.up.railway.app    │
│                                  │
│  ┌──────────┐  ┌──────────────┐  │
│  │ Security │  │  Controllers │  │
│  │  JWT     │  │  Services    │  │
│  │  CORS    │  │  Repos       │  │
│  └──────────┘  └──────────────┘  │
└───────────────┬──────────────────┘
                │ JPA / JDBC
┌───────────────▼──────────────────┐
│   PostgreSQL — Railway           │
│   Managed Database               │
└──────────────────────────────────┘
```

> Follows industry-standard **decoupled architecture** used by companies
> like GitHub, Stripe, and Vercel.

---

## 📡 API Endpoints

### Auth — Public
```http
POST /api/auth/signup
{
  "username": "john",
  "email": "john@example.com",
  "password": "password123",
  "role": ["admin"]
}

POST /api/auth/signin
{
  "username": "john",
  "password": "password123"
}
```

### Projects — JWT Required
```http
GET    /api/projects
POST   /api/projects
PUT    /api/projects/{id}
DELETE /api/projects/{id}     (Admin only)
```

### Tasks — JWT Required
```http
GET    /api/tasks
POST   /api/tasks
PUT    /api/tasks/{id}
DELETE /api/tasks/{id}        (Admin only)
```

### Users — Admin Only
```http
GET    /api/users
```

### Health — Public
```http
GET    /actuator/health
```

---

## 🔒 Role-Based Access Matrix

| Feature | 👑 Admin | 👤 Member |
|---|:---:|:---:|
| Login / Signup | ✅ | ✅ |
| View projects | ✅ | ✅ |
| Create project | ✅ | ❌ |
| Edit project | ✅ | ❌ |
| Delete project | ✅ | ❌ |
| View tasks | ✅ | ✅ |
| Create task | ✅ | ✅ |
| Update task status | ✅ | ✅ |
| Delete task | ✅ | ❌ |
| View all members | ✅ | ❌ |

---

## 📁 Project Structure

```
task-manager/
│
├── backend/                            # Spring Boot Application
│   ├── src/
│   │   └── main/
│   │       ├── java/com/taskmanager/
│   │       │   ├── config/             # App configuration
│   │       │   ├── controller/         # REST API controllers
│   │       │   │   ├── AuthController.java
│   │       │   │   ├── ProjectController.java
│   │       │   │   ├── TaskController.java
│   │       │   │   └── UserController.java
│   │       │   ├── dto/                # Request & Response DTOs
│   │       │   ├── exception/          # Global exception handler
│   │       │   ├── model/              # JPA Entities
│   │       │   │   ├── User.java
│   │       │   │   ├── Role.java
│   │       │   │   ├── Project.java
│   │       │   │   └── Task.java
│   │       │   ├── repository/         # Spring Data JPA repos
│   │       │   ├── security/           # JWT + Spring Security
│   │       │   │   ├── AuthTokenFilter.java
│   │       │   │   ├── JwtUtils.java
│   │       │   │   ├── UserDetailsImpl.java
│   │       │   │   ├── UserDetailsServiceImpl.java
│   │       │   │   └── WebSecurityConfig.java
│   │       │   └── service/            # Business logic layer
│   │       └── resources/
│   │           └── application.properties
│   ├── Dockerfile
│   ├── railway.toml
│   └── pom.xml
│
├── docs/                               # Frontend (GitHub Pages)
│   └── index.html
│
└── README.md
```

---

## ⚙️ Local Setup

### Prerequisites
- Java 21+
- Maven 3.9+
- PostgreSQL 15+

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/Suraj-1Kumar/task-manager.git
cd task-manager/backend

# 2. Create PostgreSQL database
psql -U postgres -c "CREATE DATABASE taskmanager;"

# 3. Set environment variables
export PGHOST=localhost
export PGPORT=5432
export PGDATABASE=taskmanager
export PGUSER=postgres
export PGPASSWORD=yourpassword
export JWT_SECRET=MyTaskManagerSuperSecretKey2026Minimum32Chars

# 4. Run
mvn spring-boot:run
# App runs at http://localhost:8080
```

### Frontend — No build needed
```bash
# Just open in browser
open task-manager/docs/index.html
```

### Docker
```bash
cd backend
docker build -t task-manager .
docker run -p 8080:8080 \
  -e PGHOST=host.docker.internal \
  -e PGPORT=5432 \
  -e PGDATABASE=taskmanager \
  -e PGUSER=postgres \
  -e PGPASSWORD=yourpassword \
  -e JWT_SECRET=yoursecretkey \
  task-manager
```

---

## 🚢 Deployment Guide

### Backend on Railway
1. Push code to GitHub
2. Connect repo to Railway → New Service → GitHub repo
3. Add PostgreSQL plugin from Railway dashboard
4. Set environment variables in Railway → Variables tab
5. Railway auto-builds using `Dockerfile` and deploys

### Frontend on GitHub Pages
1. Place `index.html` inside `/docs` folder in repo root
2. Go to **Settings → Pages**
3. Source: `main` branch | Folder: `/docs`
4. Save — live in ~60 seconds

---

## 🔑 Environment Variables

| Variable | Description |
|---|---|
| `PGHOST` | PostgreSQL host |
| `PGPORT` | PostgreSQL port |
| `PGDATABASE` | Database name |
| `PGUSER` | Database username |
| `PGPASSWORD` | Database password |
| `JWT_SECRET` | JWT signing secret (min 32 chars) |
| `PORT` | Server port (auto-set by Railway) |

---

## 👨‍💻 Author

**Suraj Kumar**
- GitHub: [@Suraj-1Kumar](https://github.com/Suraj-1Kumar)

---

<div align="center">
Built with Java + Spring Boot for a hiring assignment submission
</div>
