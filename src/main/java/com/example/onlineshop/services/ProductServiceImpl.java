package com.example.onlineshop.services;

import com.example.onlineshop.data.GenericRepository;
import com.example.onlineshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final GenericRepository<Product> productRepository;

    @Autowired
    public ProductServiceImpl(GenericRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getAllByName(String name) {
        List<Product> productsByName = productRepository.getAll();
        productsByName
                .stream()
                .filter(product -> product.getModel().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        return productsByName;
    }

    @Override
    public Product getById(int id) {
        return null;
    }
}
