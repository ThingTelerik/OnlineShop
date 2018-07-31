package com.example.onlineshop.services;

import com.example.onlineshop.data.GenericRepository;
import com.example.onlineshop.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final GenericRepository<Brand> repository;

    @Autowired
    public BrandServiceImpl(GenericRepository<Brand> repository) {
        this.repository = repository;
    }


    @Override
    public List<Brand> getAll() {
        return repository
                .getAll()
                .stream()
                .collect(Collectors.toList());

    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);

    }
}
