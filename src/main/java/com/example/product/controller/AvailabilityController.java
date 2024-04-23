package com.example.product.controller;

import com.example.product.model.Availability;
import com.example.product.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired AvailabilityService availabilityService;

    @PostMapping("/create")
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability){
        Availability createAvailability = availabilityService.createAvailability(availability);
        return new ResponseEntity<>(createAvailability, HttpStatus.CREATED);
    }

}
