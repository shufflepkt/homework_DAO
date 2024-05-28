package com.example.homework_dao.controller;

import com.example.homework_dao.repository.OrderedProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderedProductController {
    private OrderedProductRepository orderedProductRepository;

    public OrderedProductController(OrderedProductRepository orderedProductRepository) {
        this.orderedProductRepository = orderedProductRepository;
    }

    @GetMapping("/products/fetch-product")
    List<String> getProducts(@RequestParam("name") String name) {
        return orderedProductRepository.getProductName(name);
    }
}
