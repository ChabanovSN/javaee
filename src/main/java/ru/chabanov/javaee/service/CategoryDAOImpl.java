package ru.chabanov.javaee.service;

import ru.chabanov.javaee.beans.CategoriesBean;
import ru.chabanov.javaee.entity.Category;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named("categories")
@SessionScoped
public class CategoryDAOImpl implements CategoryDAO, Serializable {

    @Inject
    private CategoriesBean categoriesBean;

    @Override
    public Collection<Category> getCategoryList() {
        return categoriesBean.getCategoryList();
    }

    @Override
    public String editAction(Category category) {
        return categoriesBean.editAction(category);
    }

    @Override
    public void deleteAction(Category category) {
      categoriesBean.deleteAction(category);
    }

    @Override
    public String saveProduct() {
        return categoriesBean.saveProduct();
    }
}
