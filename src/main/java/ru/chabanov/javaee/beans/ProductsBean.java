package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.repository.ProductRepository;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("products")
@SessionScoped
public class ProductsBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductsBean.class);

    @Inject
    private ProductRepository productRepository;

    @Getter
    @Setter
    @Inject
    private CategoriesBean categoriesBean;
    // наличие такого поля для хранения текущего элемента является стандартным для JSF
   @Getter
   @Setter
    private Product product;


    public Collection<Product> getProductList() {
        return productRepository.getAll();
    }

    public String editAction(Product product) {

        this.product = product; // сохраняем продукт для редактирования
        return "/product.xhtml?faces-redirect=true"; // возвращаем адрес страницы на которую переходим для редактирования
    }

    public void deleteAction(Product product) {
        productRepository.remove(product);
    }

    public String saveProduct() {
        product.setCategory(categoriesBean.getCategory());
        productRepository.merge(product);
        return "/index.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }

}