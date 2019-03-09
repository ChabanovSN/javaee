package ru.chabanov.javaee.repository;

import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.utils.FillRepositoryies;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс-заглушка для репозитория
 * через несколько уроков мы его заменим на
 * полноценный JPA репозиторий
 */
@Named
@ApplicationScoped
public class ProductRepository {

    private Map<String, Product> productMap;

    public ProductRepository() {
       productMap = FillRepositoryies.getProductMap();
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }

    public Product getById(String id) {
        return productMap.get(id);
    }

    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(Product product) {
        productMap.remove(product.getId());
    }
}