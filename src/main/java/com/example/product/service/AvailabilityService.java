package com.example.product.service;

import com.example.product.model.Availability;
import com.example.product.model.Product;
import com.example.product.repository.IAvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Autowired
    private IAvailabilityRepo availabilityRepo;
    public Availability createAvailability(Availability availability) {
        return availabilityRepo.save(availability);
    }

}
