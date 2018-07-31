package com.example.onlineshop.services;

import com.example.onlineshop.models.Brand;


import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand getById(int id);
}
