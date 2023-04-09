package com.example.ProductService.dao;

import com.example.ProductService.domain.Product;

public interface ProductDAO {
    Product getProduct(Long productNo);
}
