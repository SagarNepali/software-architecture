package com.example.ProductService.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", url = "http://localhost:8900/api/v1/stock-service")
public interface StockServiceFeignClient {

    @RequestMapping("/{productNo}")
    Integer getCount(@PathVariable("productNo") Long productNo);
}
