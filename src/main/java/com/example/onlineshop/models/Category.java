package com.example.onlineshop.models;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "category_id")
    private  int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Product> products;


    public Category() {
    }

    public Category(int id, String name) {
        setId(id);
        setName(name);
        setProducts(new HashSet<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Category:{0}",
                getName()
        );
    }
}