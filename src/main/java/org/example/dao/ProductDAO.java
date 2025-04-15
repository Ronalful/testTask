package org.example.dao;

import org.example.HibernateSessionFactoryUtil;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(product);
        tx.commit();
        session.close();
    }

    public List<Product> findProductByName(String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("from Product where name = :name", Product.class)
                .setParameter("name", name)
                .list();
    }
}
