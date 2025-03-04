#### Birthday Reminder System

A Spring Boot application designed to manage users, departments, and send birthday notifications using RabbitMQ.

## Features

# 1 User and Department Management: Easily manage users and departments within the system.

# 2 Birthday Notifications: Automatically send birthday notifications to department members.

# 3 Real-time Notifications: Utilize RabbitMQ for real-time notification delivery.

## 4 Scheduled Tasks: A scheduled task checks for birthdays every hour to ensure timely notifications.

## Technologies Used
# 1 Backend: Java, Spring Boot

# 2 Database: PostgreSQL

# 3 Message Broker: RabbitMQ

# 4 Security: Spring Security

Scheduling: Spring Scheduler

## #Setup
## Prerequisites
# 1 Java 17 or higher

# 2 PostgreSQL

# 3 RabbitMQ

# 4 Maven

## Steps to Run
# 1 Clone the Repository:

git clone https://github.com/your-username/birthday-reminder-system.git
cd birthday-reminder-system
Set Up PostgreSQL:

# 2 Create a database named birthday_reminder.

# 3 Update the application.properties file with your database credentials:

##properties

spring.datasource.url=jdbc:postgresql://localhost:5432/birthday_reminder
spring.datasource.username=your-username
spring.datasource.password=your-password
Set Up RabbitMQ:

## Install RabbitMQ or use Docker:

docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
Access the RabbitMQ management console at http://localhost:15672 (username: guest, password: guest).

## Run the Application:

# Use Maven to build and run the application:

mvn spring-boot:run

## Scheduler
# The application includes a scheduled task that checks for birthdays every hour and sends notifications to department members via RabbitMQ.

## RabbitMQ Configuration
# 1 Queue: birthdayQueue

# 2 Exchange: birthdayExchange

# 3 Routing Key: birthdayRoutingKey
