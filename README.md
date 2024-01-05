# Spring Cloud E-Commerce Application

This project is developed using Spring Boot and Spring Cloud to implement a basic e-commerce application. It includes essential services like User, Product, and Order Services, facilitating functionalities such as user registration, authentication, product listing, product details, placing orders, and viewing order details.

## Project Structure

- **discovery**: Service Discovery Center

- **gateway**: API Gateway

- **category-service**: Product Service

- **order-service**: Order Service

- **user-service**: User Service

  

### Mysql Service Configuration

For each service, make sure to config the mysql first.

```yaml

datasource:
    url: jdbc:mysql://localhost:3306/dbshop?useUnicode=true&characterEncoding=UTF-8&sessionVariables=FOREIGN_KEY_CHECKS=0&autoReconnect=true
    username: root
    password: root
```



## Database Scripts

The DDL (Data Definition Language) and DML (Data Manipulation Language) scripts for setting up and managing the database are located in the `db` folder of the project.



## Start Order for Services

Below is the recommended start order:

1. **Discovery Service (Eureka)**
   - **Project Folder**: `discovery`
2. **Gateway Service**
   - **Project Folder**: `gateway`
3. **Category Service (Product Service)**
   - **Project Folder**: `category-service`
4. **User Service**
   - **Project Folder**: `user-service`
5. **Order Service**
   - **Project Folder**: `order-service`
