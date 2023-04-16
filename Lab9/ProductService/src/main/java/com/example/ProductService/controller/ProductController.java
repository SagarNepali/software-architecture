package com.example.ProductService.controller;

import com.example.ProductService.domain.Product;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/product-service")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{productNo}")
    @ResponseStatus(HttpStatus.OK)
    @HystrixComand(fallbackMethod ="stockServiceFallback")
    public Product getProduct(@PathVariable("productNo") Long productNo){
        return productService.getProduct(productNo);
    }

    public String stockServiceFallback() {
        return "Could not get Stock info. Please try after sometime";
    }
}
