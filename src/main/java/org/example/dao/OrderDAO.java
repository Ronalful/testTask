package org.example.dao;

import org.example.HibernateSessionFactoryUtil;
import org.example.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDAO {
    public void save(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(order);
        tx.commit();
        session.close();
    }

    public List<Order> findAllByCustomerName(String customerName) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("from Order where customerName = :customerName", Order.class)
                .setParameter("customerName", customerName)
                .list();
    }

    public List<Order> findAll() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Order").list();
    }
}
