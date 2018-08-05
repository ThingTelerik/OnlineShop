package com.example.onlineshop.AppConfig;

import com.example.onlineshop.data.GenericRepository;
import com.example.onlineshop.data.HibernateRepository;
import com.example.onlineshop.data.HibernateUtils;
import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Category;
import com.example.onlineshop.models.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "Product")
    @Autowired
    public GenericRepository<Product> provideProductRepo(SessionFactory sessionFactory){
        GenericRepository<Product> productGenericRepository = new HibernateRepository<>(sessionFactory);
        ((HibernateRepository<Product>) productGenericRepository).setEntityClass(Product.class);

        return productGenericRepository;
    }

    @Bean(name = "Brand")
    @Autowired
    public GenericRepository<Brand> provideBrandRepo(SessionFactory sessionFactory){
        GenericRepository<Brand> brandGenericRepository = new HibernateRepository<>(sessionFactory);
        ((HibernateRepository<Brand>) brandGenericRepository).setEntityClass(Brand.class);

        return brandGenericRepository;
    }

    @Bean(name = "Category")
    @Autowired
    public GenericRepository<Category> provideCategoryRepo(SessionFactory sessionFactory){
        GenericRepository<Category> categoryGenericRepository = new HibernateRepository<>(sessionFactory);
        ((HibernateRepository<Category>) categoryGenericRepository).setEntityClass(Category.class);

        return categoryGenericRepository;
    }


    @Bean
    public SessionFactory provideSessionFactory() {
        return HibernateUtils.getSessionFactory();
    }
}
