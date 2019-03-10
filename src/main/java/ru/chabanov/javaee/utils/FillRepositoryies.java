package ru.chabanov.javaee.utils;

import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class FillRepositoryies {
    private static Map<String, Product> productMap = new LinkedHashMap<>();
    private static Map<String, Category> categoryMap = new LinkedHashMap<>();

 private static void fillingMaps() {
        if(categoryMap.isEmpty()) {
            add(new Category("Clothes", "Something for wearing"));
            add(new Category("Food", "Something for eating"));

            add(new Category("Gadget", "Something for using"));
        }
         if(productMap.isEmpty() && !categoryMap.isEmpty()) {
             add(new Product("Pen", 50, getById("1")));
             add(new Product("Pencil", 150, getById("1")));
             add(new Product("Textbook", 200, getById("1")));
             add(new Product("Paper", 500, getById("1")));
             add(new Product("Pen", 50, getById("2")));
             add(new Product("Eraser", 150, getById("1")));
             add(new Product("Marker", 200, getById("3")));
             add(new Product("Sticks", 500, getById("1")));
             add(new Product("Brash", 50, getById("2")));
             add(new Product("Pencil", 150, getById("1")));
             add(new Product("Textbook", 200, getById("3")));
             add(new Product("Paper", 500, getById("1")));
             add(new Product("Pen", 50, getById("2")));
             add(new Product("Pencil", 150, getById("1")));
             add(new Product("Textbook", 200, getById("3")));
             add(new Product("Paper", 500, getById("2")));
         }
    }

    private static void add(Product product) {
        productMap.put(product.getId(), product);
    }


    private static void add(Category category){
        categoryMap.put(category.getId(),category);
    }

    private static Category getById(String id) {
        if(categoryMap.containsKey(id))  return categoryMap.get(id);
        return null;
    }

    public static Map<String, Product> getProductMap() {
     fillingMaps();
        return productMap;
    }

    public static Map<String, Category> getCategoryMap() {
     fillingMaps();
        return categoryMap;
    }
}
