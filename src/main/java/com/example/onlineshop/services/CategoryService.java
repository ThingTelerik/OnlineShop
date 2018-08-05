package com.example.onlineshop.services;

import com.example.onlineshop.models.Category;
import com.example.onlineshop.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
}
