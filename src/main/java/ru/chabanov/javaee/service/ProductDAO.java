package ru.chabanov.javaee.service;

import ru.chabanov.javaee.entity.Product;

import java.util.Collection;

public interface ProductDAO {
    Collection<Product> getProductList();
    String editAction(Product product);
    void deleteAction(Product product);
    String saveProduct();
    void addToCart(Product product);
}
