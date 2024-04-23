package com.example.product.service;

import com.example.product.model.Attribute;
import com.example.product.repository.IAttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeService {

    @Autowired
    private IAttributeRepo iAttributeRepo;


    public Attribute createAttribute(Attribute attribute) {
        return iAttributeRepo.save(attribute);
    }
}
