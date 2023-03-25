package com.example.StockService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/stock-service")
public class StockController {

    private static final Map<Long,Integer> inventory;

    static {
        inventory = new HashMap<>(){
            {
                Random random = new Random();
                put(1L,random.nextInt(10000));
                put(2L,random.nextInt(10000));
                put(3L,random.nextInt(10000));
                put(4L,random.nextInt(10000));
                put(5L,random.nextInt(10000));
            }
        };
    }

    @GetMapping(value = "/{productNo}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getCount(@PathVariable("productNo") Long productNo){
        Integer count = inventory.get(productNo);
        return count == null ? 0 : count;
    }
}
