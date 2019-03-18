package ru.chabanov.javaee.service;

import ru.chabanov.javaee.beans.OrdersBean;
import ru.chabanov.javaee.entity.Order;
import ru.chabanov.javaee.entity.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Named("orders")
@SessionScoped
public class OrderDAOImpl implements Serializable,OrderDAO {

    @EJB
    private OrdersBean ordersBean;



    @Override
    public List<Product> getProducts() {
        return ordersBean.getProducts();
    }

    @Override
    public Collection<Order> getOrdersList() {
        return ordersBean.getOrdersList();
    }

    @Override
    public String editAction(Order order) {
        return ordersBean.editAction(order);
    }

    @Override
    public void deleteAction(Order order) {
           ordersBean.deleteAction(order);
    }

    @Override
    public String saveOrder() {
        return ordersBean.saveOrder();
    }
}
