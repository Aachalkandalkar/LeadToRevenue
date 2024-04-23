package com.example.product.repository;

import com.example.product.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttributeRepo extends JpaRepository<Attribute,Integer> {

}
