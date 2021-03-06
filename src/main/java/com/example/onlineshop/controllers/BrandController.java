package com.example.onlineshop.controllers;

import com.example.onlineshop.models.Brand;
import com.example.onlineshop.models.Product;
import com.example.onlineshop.services.BrandService;
import com.example.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BrandController {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brand")
    public String getAll(Model model){
        brandService.getAll().stream().forEach(System.out::println);
        List<Brand> brands = brandService.getAll();
        model.addAttribute("brands", brands);

        //return productService.getAll();
        return "index";

    }
    @ExceptionHandler
    ResponseEntity handleException(Exception e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
