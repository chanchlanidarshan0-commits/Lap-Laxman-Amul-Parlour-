package com.lap.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Map<String, Object>> getProducts() {
        List<Map<String, Object>> products = new ArrayList<>();

        products.add(Map.of("id", 1, "name", "Amul Taaza Milk 500ml", "price", 25.0));
        products.add(Map.of("id", 2, "name", "Amul Butter 100g", "price", 50.0));
        products.add(Map.of("id", 3, "name", "Amul Ice Cream 500ml", "price", 120.0));
        products.add(Map.of("id", 4, "name", "Amul Ghee 500g", "price", 450.0));
        products.add(Map.of("id", 5, "name", "Amul Paneer 200g", "price", 110.0));

        return products;
    }
}
