package com.example.product.repository;

import com.example.product.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRatingsRepo extends JpaRepository<Rating,Integer> {
    boolean existsByUserIdAndProduct_ProductIdAndRating(int userId, int productId, int rating);
    Optional<Rating> findByUserIdAndProduct_ProductIdAndRating(int userId, int productId, int rating);
}
