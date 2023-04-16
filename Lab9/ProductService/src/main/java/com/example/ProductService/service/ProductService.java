package com.example.ProductService.service;

import com.example.ProductService.dao.ProductDAO;
import com.example.ProductService.domain.Product;
import com.example.ProductService.integration.StockServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class ProductService {

    @Autowired
    RestOperations restTemplate;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    StockServiceFeignClient stockServiceFeignClient;

    public Product getProduct(Long productNo){
        Product product = productDAO.getProduct(productNo);
        product.setStockCount(getStockCount(productNo));
        return product;
    }

    private Integer getStockCount(Long productNo) {
        //return restTemplate.getForObject("http://localhost:8900/api/v1/stock-service/"+productNo, Integer.class);
        return stockServiceFeignClient.getCount(productNo);
    }
}
