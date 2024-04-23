package com.example.product.repository;

import com.example.product.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvailabilityRepo extends JpaRepository<Availability,Integer> {
}
