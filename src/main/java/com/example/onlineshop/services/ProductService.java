package com.example.onlineshop.services;

import com.example.onlineshop.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getAllByName(String name);

    Product getById(int id);
}
