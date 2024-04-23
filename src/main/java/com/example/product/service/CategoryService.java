package com.example.product.service;

import com.example.product.model.Availability;
import com.example.product.model.Category;
import com.example.product.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepo iCategoryRepo;

    public Category createCategory(Category category) {
        return iCategoryRepo.save(category);
    }


}
