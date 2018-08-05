package com.example.onlineshop.controllers;

import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Category;
import com.example.onlineshop.services.BrandService;
import com.example.onlineshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class CategoryController {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping("/category")
    public String getAll(Model model){
        service.getAll().stream().forEach(System.out::println);
        List<Category> categories = service.getAll();
        model.addAttribute("categories", categories);

        //return productService.getAll();
        return "index";

    }


    @ExceptionHandler
    ResponseEntity handleException(Exception e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



}


