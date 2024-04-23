package com.example.product.controller;

import com.example.product.model.Attribute;
import com.example.product.model.Availability;
import com.example.product.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping("/create")
    public ResponseEntity<Attribute> createAttribute(@RequestBody Attribute attribute){
        Attribute createAttribute = attributeService.createAttribute(attribute);
        return new ResponseEntity<>(createAttribute, HttpStatus.CREATED);
    }

}
