package ru.chabanov.javaee.service;

import ru.chabanov.javaee.entity.Order;
import ru.chabanov.javaee.entity.Product;

import java.util.Collection;
import java.util.List;

public interface OrderDAO {



     List<Product> getProducts();
    Collection<Order> getOrdersList();
    String editAction(Order order);
     void deleteAction(Order order);
    String saveOrder();
}
