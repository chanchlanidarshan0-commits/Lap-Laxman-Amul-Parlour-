package com.lap.controller;

import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping
    public String createOrder(@RequestBody OrderRequest req) {
        String url = "jdbc:mysql://localhost:3306/lap_grocery";
        String user = "root";      // change if your MySQL user is different
        String pass = "";          // put your MySQL password here

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO orders (customer_name, customer_phone, items, total) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, req.customerName);
            ps.setString(2, req.customerPhone);
            ps.setString(3, req.items.toString());   // store JSON as text
            ps.setDouble(4, req.total);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            long id = 0;
            if (rs.next()) id = rs.getLong(1);

            conn.close();
            return "Order ID: " + id;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static class OrderRequest {
        public String customerName;
        public String customerPhone;
        public List<Object> items;
        public double total;
    }
}
