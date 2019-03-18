package ru.chabanov.javaee.beans;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Order;
import ru.chabanov.javaee.repository.CategoryRepository;
import ru.chabanov.javaee.repository.OrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named("orders")
@SessionScoped
public class OrdersBean implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    @Inject
    private OrderRepository repository;

    @Getter
    @Setter
    private Order order;


    public Collection<Order> getCategoryList() {
        return repository.getAll();
    }

    public String editAction(Order order) {
        this.order = order; // сохраняем продукт для редактирования
        return "/order.xhtml?faces-redirect=true"; // возвращаем адрес страницы на которую переходим для редактирования
    }

    public void deleteAction(Order order) {
        repository.remove(order);
    }

    public String saveOrder() {
       repository.merge(order);
        return "/index.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }
}
