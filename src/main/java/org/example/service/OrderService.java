package org.example.service;

import org.example.dao.OrderDAO;
import org.example.model.Order;

import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO = new OrderDAO();

    public boolean save(Order order) {
        orderDAO.save(order);
        return true;
    }

    public List<Order> findAllOrderByCustomerName(String customerName) {
        return orderDAO.findAllByCustomerName(customerName);
    }

    public List<Order> findAll() {
        return orderDAO.findAll();
    }
}
