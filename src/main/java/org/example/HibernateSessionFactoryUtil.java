package org.example;
import org.example.model.Order;
import org.example.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Order.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
