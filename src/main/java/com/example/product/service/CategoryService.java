package com.example.product.service;

import com.example.product.model.Attribute;
import com.example.product.model.Availability;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepo categoryRepo;

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }


}
