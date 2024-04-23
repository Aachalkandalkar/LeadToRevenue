package com.example.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull
    private String productName;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @ManyToMany
    private List<Category> categories = new ArrayList<>() ;

    @OneToMany
    private List<Attribute> attributes = new ArrayList<>();

    @OneToOne
    private Availability availability;

    @OneToMany
    private List<Ratings> rating = new ArrayList<>();

}
