package ru.chabanov.javaee.service;

import ru.chabanov.javaee.entity.Category;

import java.util.Collection;

public interface CategoryDAO {
     Collection<Category> getCategoryList();
    String editAction(Category category);
    void deleteAction(Category category);
    String saveProduct();
}
