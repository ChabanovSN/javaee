package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.repository.CategoryRepository;
import ru.chabanov.javaee.repository.ProductRepository;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Stateless
public class CategoriesBean implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(CategoriesBean.class);

    @Inject
    private CategoryRepository repository;

    @Getter
    @Setter
    private Category category;


    public Collection<Category> getCategoryList() {
        return repository.getAll();
    }

    public String editAction(Category category) {
        this.category = category; // сохраняем продукт для редактирования
        return "/category.xhtml?faces-redirect=true"; // возвращаем адрес страницы на которую переходим для редактирования
    }

    public void deleteAction(Category category) {
        repository.remove(category);
    }

    public String saveProduct() {
       repository.merge(category);
        return "/index.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }
}
