package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import product.domain.Product;
import product.service.ProductQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-query")
public class ProductController {

    @Autowired
    ProductQueryService productQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll(){
        return productQueryService.findAll();
    }

    @GetMapping("/{productNo}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable("productNo") Long productNo) {
        return productQueryService.findById(productNo);
    }
}
