🗂️ Task Management System (Spring Boot)

 📌 Project Description

This is a **Task Management System** built using **Spring Boot** and **REST APIs**.
The application allows users to create and manage tasks with **categories**, **priorities**, and **statuses**.

The project follows **clean layered architecture**:

* Controller → Request/Response only
* Service → Business logic
* Repository → Database access
* DTOs → Prevent direct entity exposure

🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Lombok
* Swagger OpenAPI

🧱 Database Design

 Entities

* **User**
* **Category**
* **Priority**
* **Task**

 Relationships

* Task → ManyToOne → User
* Task → ManyToOne → Category
* Task → ManyToOne → Priority

 Enum

* TaskStatus

  * `PENDING`
  * `IN_PROGRESS`
  * `DONE`


🚀 How to Run the Project

 1️⃣ Prerequisites

* Java 17+
* Maven
* PostgreSQL
* IDE (IntelliJ / Eclipse)

 2️⃣ Create Database

```sql
CREATE DATABASE task_management_db;
```

 3️⃣ Configure application.properties

Update credentials in:

```
src/main/resources/application.properties
```

 4️⃣ Run Application

```bash
mvn spring-boot:run
```

 5️⃣ Access Swagger UI

```
http://localhost:8080/swagger-ui.html
```

---

🔗 API Endpoints

👤 User Endpoints

| Method | Endpoint              | Description    |
| ------ | --------------------- | -------------- |
| POST   | `/api/users`          | Create User    |
| GET    | `/api/users`          | Get All Users  |
| GET    | `/api/users/{userId}` | Get User by ID |
| PUT    | `/api/users/{userId}` | Update User    |
| DELETE | `/api/users/{userId}` | Delete User    |

---

### 🏷️ Category Endpoints

| Method | Endpoint                       | Description        |
| ------ | ------------------------------ | ------------------ |
| POST   | `/api/categories`              | Create Category    |
| GET    | `/api/categories`              | Get All Categories |
| GET    | `/api/categories/{categoryId}` | Get Category by ID |
| PUT    | `/api/categories/{categoryId}` | Update Category    |
| DELETE | `/api/categories/{categoryId}` | Delete Category    |

---

### ⚡ Priority Endpoints

| Method | Endpoint                       | Description        |
| ------ | ------------------------------ | ------------------ |
| POST   | `/api/priorities`              | Create Priority    |
| GET    | `/api/priorities`              | Get All Priorities |
| GET    | `/api/priorities/{priorityId}` | Get Priority by ID |
| PUT    | `/api/priorities/{priorityId}` | Update Priority    |
| DELETE | `/api/priorities/{priorityId}` | Delete Priority    |

---

### ✅ Task Endpoints

| Method | Endpoint                     | Description        |
| ------ | ---------------------------- | ------------------ |
| POST   | `/api/tasks`                 | Create Task        |
| GET    | `/api/tasks`                 | Get All Tasks      |
| GET    | `/api/tasks/{taskId}`        | Get Task by ID     |
| PUT    | `/api/tasks/{taskId}`        | Update Task        |
| PUT    | `/api/tasks/{taskId}/status` | Update Task Status |
| DELETE | `/api/tasks/{taskId}`        | Delete Task        |


 🧪 Testing Order (VERY IMPORTANT)

Follow this order to avoid errors:

1. Create User
2. Create Category
3. Create Priority
4. Create Task
5. Update Task Status
6. Get Tasks


⚠️ Exception Handling

Custom exceptions are handled globally using `@RestControllerAdvice`:

* UserNotFoundException
* TaskNotFoundException

Returns clean and meaningful error responses.
 📄 API Documentation

Swagger OpenAPI is integrated.

* URL: `http://localhost:8080/swagger-ui.html`

 ✅ Status

✔ CRUD operations implemented
✔ Clean architecture
✔ Swagger documentation
✔ PostgreSQL integration
