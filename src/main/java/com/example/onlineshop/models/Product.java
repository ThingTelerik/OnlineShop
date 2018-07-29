package com.example.onlineshop.models;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id",
            referencedColumnName = "brand_id")
    private Brand brand;

    @Column( name = "model", nullable = false)
    private String model;
    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Product() {
    }

    public Product(int id, Brand brand, String model, String description, float price, int quantity, Category category) {
        setId(id);
        setBrand(brand);
        setModel(model);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "({0}, {1}, {2}, {3}, {4}, {5})",
                getId(),
                getBrand(),
                getModel(),
                getPrice(),
                getQuantity(),
                getCategory()
        );
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

