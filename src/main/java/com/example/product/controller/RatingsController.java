package com.example.product.controller;

import com.example.product.model.Rating;
import com.example.product.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRatings(@RequestBody Rating rating){
        Rating createRating = ratingService.createRatings(rating);
        return new ResponseEntity<>(createRating, HttpStatus.CREATED);
    }
}
