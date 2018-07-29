package com.example.onlineshop.data;

import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Category;
import com.example.onlineshop.models.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration  = new Configuration().configure();

        configuration.addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).addAnnotatedClass(Brand.class);

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        serviceRegistryBuilder.applySettings(configuration.getProperties());
        StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory= configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
