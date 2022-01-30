package com.example.TestTechnique.repositories;

import java.util.List;

import com.example.TestTechnique.models.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

    List<Product> findByCategoryId(String categoryId);
}
