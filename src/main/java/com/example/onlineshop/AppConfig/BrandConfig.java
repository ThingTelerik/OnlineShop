package com.example.onlineshop.AppConfig;

import com.example.onlineshop.data.GenericRepository;
import com.example.onlineshop.data.HibernateRepository;
import com.example.onlineshop.data.HibernateUtils;
import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrandConfig {
    @Bean(name = "Brand")
    @Autowired
    public GenericRepository<Brand> provideBrandRepo(SessionFactory sessionFactory){
        GenericRepository<Brand> brandGenericRepository = new HibernateRepository<>(sessionFactory);
        ((HibernateRepository<Brand>) brandGenericRepository).setEntityClass(Brand.class);

        return brandGenericRepository;
    }

    @Bean
    public SessionFactory provideSessionFactory() {
        return HibernateUtils.getSessionFactory();
    }
}
