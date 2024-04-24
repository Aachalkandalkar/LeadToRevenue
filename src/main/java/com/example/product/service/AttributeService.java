package com.example.product.service;

import com.example.product.model.Attribute;
import com.example.product.model.Product;
import com.example.product.repository.IAttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private IAttributeRepo attributeRepo;


    public Attribute createAttribute(Attribute attribute) {
        return attributeRepo.save(attribute);
    }

}
