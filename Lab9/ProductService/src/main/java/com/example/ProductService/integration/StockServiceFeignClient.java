package com.example.ProductService.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stockservice")
public interface StockServiceFeignClient {

    @RequestMapping("/api/v1/stock-service/{productNo}")
    Integer getCount(@PathVariable("productNo") Long productNo);
}
