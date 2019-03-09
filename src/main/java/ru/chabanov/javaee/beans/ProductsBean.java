package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.repository.ProductRepository;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;


@ManagedBean(name = "products")
@SessionScoped // будьте осторожны с бинами Scoped. Они есть как в JSF так и в CDI
public class ProductsBean {

    private static final Logger logger = LoggerFactory.getLogger(ProductsBean.class);

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CategoriesBean categoriesBean;
    // наличие такого поля для хранения текущего элемента является стандартным для JSF
   @Getter
   @Setter
    private Product product;


    public String getId() {
        return product.getId();
    }



    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        product.setName(name);
    }

    public int getPrice() {
        return product.getPrice();
    }

    public void setPrice(int price) {
        product.setPrice(price);
    }



    public Collection<Product> getProductList() {
        return productRepository.getAll();
    }

    public String editAction(Product product) {

        this.product = product; // сохраняем продукт для редактирования
        return "/product.xhtml?faces-redirect=true"; // возвращаем адрес страницы на которую переходим для редактирования
    }

    public void deleteAction(Product product) {
        productRepository.delete(product);
    }

    public String saveProduct() {
        product.setCategory(categoriesBean.getCategory());
        productRepository.save(product);
        return "/index.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }

    public CategoriesBean getCategoriesBean() {
        return categoriesBean;
    }

    public void setCategoriesBean(CategoriesBean categoriesBean) {
        this.categoriesBean = categoriesBean;
    }
}