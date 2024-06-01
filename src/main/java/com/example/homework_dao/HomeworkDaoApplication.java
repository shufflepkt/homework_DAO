package com.example.homework_dao;

import com.example.homework_dao.entity.Customer;
import com.example.homework_dao.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HomeworkDaoApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        new SpringApplication(HomeworkDaoApplication.class).run(args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer("Yury", "Shakhmatov", 39, "+79999999999");
        Customer customer2 = new Customer("Dmitry", "Stepanov", 30, "+78888888888");
        Customer customer3 = new Customer("Alex", "Ivanov", 25, "+79056666666");
        Customer customer4 = new Customer("Alexey", "Pertov", 21, "+79079898989");
        Customer customer5 = new Customer("alexey", "Sidorov", 45, "+79170000001");
        Customer customer6 = new Customer("ALEXEY", "Platonov", 19, "+79250000007");

        List<Customer> customers = List.of(customer1, customer2, customer3, customer4, customer5, customer6);
        for (Customer customer : customers) {
            entityManager.persist(customer);
        }

        List<Order> orders = List.of(
                new Order(new java.util.Date(2024-1900, 04,19), customer1, "Samsung TV", 1),
                new Order(new java.util.Date(2023-1900, 11,10), customer2, "Laptop Lenovo", 2),
                new Order(new java.util.Date(2024-1900, 02,01), customer3, "Router MX", 3),
                new Order(new java.util.Date(2024-1900, 03,14), customer4, "PlayStation-6", 4),
                new Order(new Date(2024-1900, 04,19), customer5, "iPhone 12Pro", 5)
        );

        for (Order order : orders) {
            entityManager.persist(order);
        }
    }
}
