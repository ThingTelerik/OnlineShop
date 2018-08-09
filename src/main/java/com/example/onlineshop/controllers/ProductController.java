package com.example.onlineshop.controllers;

import com.example.onlineshop.models.Product;
import com.example.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        productService.getAll().stream().forEach(System.out::println);
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        //return productService.getAll();
        return "index";

    }

    @GetMapping("/search")
    public String showProductsByName(@RequestParam(value = "productName", required = false)  String name, Model model){
        List<Product> products = this.productService.getAllByName(name);
        model.addAttribute("search", true);
        model.addAttribute("productsByName", products);

        return "search";
    }
}
