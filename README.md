# 🏪 Inventory Management System API

A **Spring Boot + MySQL RESTful API** designed to efficiently manage products, stock levels, and inventory operations.  
This project demonstrates CRUD operations, threshold-based queries, and stock management using industry-standard REST principles.

---

## 🚀 Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **JDK Version:** 17+  
- **Packaging:** JAR  

---

## 📦 Features

✅ Fetch all products  
✅ Retrieve product details by ID  
✅ Get products below a stock threshold  
✅ Add new products  
✅ Update existing products  
✅ Increase or decrease stock quantity  
✅ Delete products  

---

## 🧩 API Endpoints

| HTTP Method | Endpoint | Description |
|--------------|-----------|-------------|
| **GET** | `/api/v1/products` | Get all products |
| **GET** | `/api/v1/products/{id}` | Get details of a specific product by ID |
| **GET** | `/api/v1/products/below-threshold` | Get products with stock below threshold |
| **POST** | `/api/v1/products` | Create a new product |
| **PUT** | `/api/v1/products/{id}` | Update a product by ID |
| **PUT** | `/api/v1/products/increase/{id}` | Increase stock quantity of a product |
| **PUT** | `/api/v1/products/decrease/{id}` | Decrease stock quantity of a product |
| **DELETE** | `/api/v1/products/{id}` | Delete a product by ID |

---

## 🗃️ Sample Product JSON

### ➕ Create or Update Product (`POST` / `PUT`)
```json
{
  "productName": "Wireless Mouse",
  "description": "Compact Bluetooth wireless mouse",
  "stockQuantity": 50
}
```

## 📈 Increase/Decrease Stock Quantity (PUT)
```
{
  "quantity": 5
}
```

## ⚙️ Setup Instructions
### 1️⃣ Clone the repository
```
git clone https://github.com/<your-username>/inventory-management-system.git
cd inventory-management-system
```

### 2️⃣ Configure MySQL Database

Create a database in MySQL:
```
CREATE DATABASE ims;
```

### 3️⃣ Update application.properties
```
spring.application.name=ims_backend
spring.datasource.url=jdbc:mysql://localhost:3306/ims?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 4️⃣ Build and Run the Project
```
mvn clean install
mvn spring-boot:run
```

### 5️⃣ Access the APIs

Once started, the application will be available at:
```
http://localhost:8080/api/v1/products
```

## 🧠 Project Structure
src/main/java/com/example/inventory/
│
├── controller/       # Handles incoming REST requests
├── service/          # Business logic layer
├── repository/       # Database access layer (JPA)
├── model/            # Entity classes
└── InventoryApplication.java  # Main entry point

## 🧾 Example Responses
### ✅ Get All Products
```
[
  {
    "id": 1,
    "productName": "Wireless Mouse",
    "description": "Compact Bluetooth wireless mouse",
    "stockQuantity": 50
  },
  {
    "id": 2,
    "productName": "Mechanical Keyboard",
    "description": "RGB backlit keyboard",
    "stockQuantity": 25
  }
]
```

### 🧑‍💻 Author

#### Sitesh Kumar
💼 Software Developer | Java & Spring Boot Developer
📧 siteshk2020@gmail.com


### 📝 License

This project is licensed under the MIT License — feel free to use and modify it.

## ⭐ If you like this project, give it a star on GitHub.

