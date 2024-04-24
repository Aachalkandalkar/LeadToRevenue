package com.example.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Category> categories = new ArrayList<>() ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Attribute> attributes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private Availability availability;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Rating> rating = new ArrayList<>();

}
