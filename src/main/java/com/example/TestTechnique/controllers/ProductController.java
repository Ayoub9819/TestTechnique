package com.example.TestTechnique.controllers;

import java.io.Console;
import java.util.*;

import com.example.TestTechnique.exceptions.ApiExceptionHandler;
import com.example.TestTechnique.exceptions.ApiRequestException;
import com.example.TestTechnique.exceptions.ApiServerException;
import com.example.TestTechnique.models.Product;
import com.example.TestTechnique.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    private List<Product> products;

    @GetMapping("/getProductsByCategoryId/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable("categoryId") String categoryId){
            products= productRepository.findByCategoryId(categoryId);
            for(int i=0; i<products.size(); i++){
                if(products.get(i).getQuantity() <= 0){
                    products.remove(i);
                }
            }
            if(products.size() != 0){
                return products;
            }
            else{
                throw new ApiRequestException("No products available!");
            }
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
         productRepository.save(product);
         return "added";
    }
}
