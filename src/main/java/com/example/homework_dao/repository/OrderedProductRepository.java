package com.example.homework_dao.repository;

import com.example.homework_dao.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderedProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductName(String name) {
        List<Order> orders = entityManager.createQuery("select o from Order o where lower(o.customer.name) = :name", Order.class).setParameter("name", name).getResultList();
        return orders.stream().map(Order::getProductName).collect(Collectors.toList());
    }
}
