package com.example.onlineshop.services;

import com.example.onlineshop.data.GenericRepository;
import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final GenericRepository<Category> repository;

    @Autowired
    public CategoryServiceImpl(GenericRepository<Category> repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository
                .getAll();

    }


    @Override
    public Category getById(int id) {
        return repository.getById(id);

    }


}
