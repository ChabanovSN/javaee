package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Order;
import ru.chabanov.javaee.entity.Product;
import ru.chabanov.javaee.repository.CategoryRepository;
import ru.chabanov.javaee.repository.OrderRepository;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateful
public class OrdersBean implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    @Inject
    private OrderRepository repository;

    @Getter
    @Setter
    private Order order;


    public Collection<Order> getOrdersList() {
        return repository.getAll();
    }

    public String editAction(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteAction(Order order) {
        repository.remove(order);
    }

    public String saveOrder() {
        order.setProducts(products);
       repository.merge(order);
        return "/index.xhtml?faces-redirect=true";
    }


    public void addToCard(Product product) {
        products.add(product);
    }
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
