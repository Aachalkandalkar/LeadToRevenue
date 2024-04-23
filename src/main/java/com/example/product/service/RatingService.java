package com.example.product.service;

import com.example.product.model.Ratings;
import com.example.product.repository.IRatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired IRatingsRepo iRatingsRepo;

    public Ratings createRatings(Ratings ratings) {
        return iRatingsRepo.save(ratings);
    }
}
