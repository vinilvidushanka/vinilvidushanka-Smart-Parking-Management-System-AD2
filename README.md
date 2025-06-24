# Smart Parking Management System (SPMS)

This is the final examination project for the Graduate Diploma in Software Engineering – ITS 1018: Software Architectures & Design Patterns II.

## 📘 Project Overview

Smart Parking Management System (SPMS) is a microservice-based application built using Spring Boot. It provides a smart solution to the problem of urban parking by allowing drivers to find and reserve parking spaces, and parking space owners to manage availability in real-time.

### 🎯 Key Features

- Dynamic parking space availability and reservation
- Vehicle entry and exit tracking
- User registration and profile management
- Digital payment simulation and receipts
- Microservices registered with Eureka Discovery Server
- Centralized configuration with Spring Cloud Config
- Unified routing via API Gateway

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Cloud (Eureka, Config Server, Gateway)
- Spring Data JPA
- H2 / MySQL
- Postman
- Maven

## 🧩 Microservices Architecture

- **Config Server** - Centralized config for all microservices
- **Eureka Server** - Service registry and discovery
- **API Gateway** - Routing requests to backend services
- **User Service** - Manages user and owner accounts
- **Vehicle Service** - Manages vehicle registration and tracking
- **Parking Service** - Handles parking space reservation and status
- **Payment Service** - Simulates payment transactions and receipts

---

## 📄 Resources

- 🔗 [Postman Collection](./postman_collection.json)
- 🖼️ ![Eureka Dashboard](./docs/screenshots/eureka_dashboard.png)
  <img src="C:\Users\User\IdeaProjects\AD2\Smart Parking Management System\docs\screenshots\eureka_dashboard.png.png" width="600"/>

---

## 🚀 Technologies Used

| Technology            | Purpose                                      |
|-----------------------|----------------------------------------------|
| Spring Boot           | Core microservice framework                  |
| Spring Cloud Eureka   | Service registry and discovery               |
| Spring Cloud Config   | Centralized configuration management         |
| Spring Cloud Gateway  | API Gateway for routing requests             |
| Spring Web            | RESTful web services                         |
| Postman               | API testing tool                             |

---

## 📈 Features

- 🔎 Search and reserve parking spaces in real-time
- 🧾 Simulated digital payments and receipt generation
- 🚘 Vehicle entry and exit simulation
- 📊 Usage tracking by city, zone, and owner
- 📚 Access to booking history and logs

---

## ✅ How to Run

1. Start `config-server` → `eureka-server` → `api-gateway`
2. Then start each microservice: `user-service`, `vehicle-service`, `parking-service`, `payment-service`
3. Import `postman_collection.json` into Postman
4. Use Postman to test the endpoints

---

## 🙋‍♂️ Author

Vinil Vidushanka  
Graduate Diploma in Software Engineering – IJSE

---

