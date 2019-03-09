package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.repository.CategoryRepository;
import ru.chabanov.javaee.repository.ProductRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean(name = "categories")
@SessionScoped
public class CategoriesBean {

    private static final Logger logger = LoggerFactory.getLogger(ProductsBean.class);

    @Inject
    private CategoryRepository repository;


    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
   public void setId(String id){
       this.category =repository.getById(id);
   }
    public String getId() {
        return category.getId();
    }



    public String getDescription() {
        return category.getDescription();
    }

    public void setDescription(String description) {
        category.setDescription(description);
    }


    public String getName() {
        return category.getName();
    }

    public void setName(String name) {
        category.setName(name);
    }


    public Collection<Category> getCategoryList() {
        return repository.getAll();
    }

    public String editAction(Category category) {
        this.category = category; // сохраняем продукт для редактирования
        return "/category.xhtml?faces-redirect=true"; // возвращаем адрес страницы на которую переходим для редактирования
    }

    public void deleteAction(Category category) {
        repository.delete(category);
    }

    public String saveProduct() {
       repository.save(category);
        return "/index.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }
}
