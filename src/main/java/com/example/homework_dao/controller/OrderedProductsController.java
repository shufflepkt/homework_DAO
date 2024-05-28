package com.example.homework_dao.controller;

import com.example.homework_dao.repository.OrderedProductsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderedProductsController {
    private OrderedProductsRepository orderedProductsRepository;

    public OrderedProductsController(OrderedProductsRepository orderedProductsRepository) {
        this.orderedProductsRepository = orderedProductsRepository;
    }

    @GetMapping("/products/fetch-product")
    List<String> getProducts(@RequestParam("name") String name) {
        return orderedProductsRepository.getProductName(name);
    }
}
