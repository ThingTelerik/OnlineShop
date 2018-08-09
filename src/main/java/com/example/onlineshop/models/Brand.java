package com.example.onlineshop.models;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int id;


    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Product> products;

    public Brand() {
    }

    public Brand(int id, String name) {
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
                "{0}",
                getName()
        );
    }
}