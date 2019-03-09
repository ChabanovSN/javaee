package ru.chabanov.javaee.repository;

import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.utils.FillRepositoryies;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
@Named
@ApplicationScoped
public class CategoryRepository {

    private Map<String, Category> categoryMap;

    public CategoryRepository() {
       categoryMap= FillRepositoryies.getCategoryMap();
    }

    public void add(Category category){
        categoryMap.put(category.getId(),category);
    }
    public Collection<Category> getAll() {
        return categoryMap.values();
    }

    public Category getById(String id) {
        if(categoryMap.containsKey(id))  return categoryMap.get(id);
        return null;
    }

    public void save(Category category) {
        categoryMap.put(category.getId(), category);
    }

    public void delete(Category category) {
        categoryMap.remove(category.getId());
    }

}
