CREATE DATABASE lap_grocery;
USE lap_grocery;
CREATE TABLE products (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), price DECIMAL(10,2), image VARCHAR(255));
CREATE TABLE orders (id BIGINT AUTO_INCREMENT PRIMARY KEY, customer_name VARCHAR(100), customer_phone VARCHAR(15), items JSON, total DECIMAL(10,2), order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO products VALUES (1,'Amul Taaza Milk 500ml',25.00,'milk.jpg'),(2,'Amul Butter 100g',50.00,'butter.jpg'),(3,'Amul Ice Cream 500ml',120.00,'icecream.jpg'),(4,'Amul Ghee 500g',450.00,'ghee.jpg'),(5,'Amul Paneer 200g',110.00,'paneer.jpg');
