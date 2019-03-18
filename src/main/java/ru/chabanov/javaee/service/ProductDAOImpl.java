package ru.chabanov.javaee.service;

import ru.chabanov.javaee.beans.ProductsBean;
import ru.chabanov.javaee.entity.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("products")
@SessionScoped
public class ProductDAOImpl implements ProductDAO, Serializable {

    @Inject
    private ProductsBean productsBean;

    @Override
    public Collection<Product> getProductList() {
        return productsBean.getProductList();
    }

    @Override
    public String editAction(Product product) {
        return productsBean.editAction(product);
    }

    @Override
    public void deleteAction(Product product) {
         productsBean.deleteAction(product);
    }

    @Override
    public String saveProduct() {
        return productsBean.saveProduct();
    }

    @Override
    public void addToCart(Product product) {
        productsBean.addToCart(product);
    }
}
