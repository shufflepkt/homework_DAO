package com.example.homework_dao.repository;

import com.example.homework_dao.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderedProductRepository {
    private final EntityManager entityManager;

    public OrderedProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<String> getProductName(String name) {
        List<Order> orders = entityManager.createQuery("select o from Order o where lower(o.customer.name) = :name", Order.class).setParameter("name", name).getResultList();
        System.out.println(orders);
        return orders.stream().map(Order::getProductName).collect(Collectors.toList());
    }
}
