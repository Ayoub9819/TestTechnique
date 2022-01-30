package com.example.TestTechnique.repositories;

import com.example.TestTechnique.models.Category;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Long>{
    
}
