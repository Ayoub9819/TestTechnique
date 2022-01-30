package com.example.TestTechnique.controllers;

import java.util.List;

import com.example.TestTechnique.exceptions.ApiRequestException;
import com.example.TestTechnique.models.Category;
import com.example.TestTechnique.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            //System.out.println("error");
            throw new ApiRequestException("No categories available");
        }
      
    }
    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category category) {
         categoryRepository.save(category);
        return "added";
    }
}
