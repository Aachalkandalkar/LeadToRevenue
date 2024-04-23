package com.example.product.repository;

import com.example.product.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingsRepo extends JpaRepository<Ratings,Integer> {
}
