package com.example.product.service;

import com.example.product.model.Rating;
import com.example.product.repository.IRatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired IRatingsRepo ratingsRepo;

    public Rating createRatings(Rating rating) {
        return ratingsRepo.save(rating);
    }


}
