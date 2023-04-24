package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import product.domain.Product;
import product.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/{productNo}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable("productNo") Long productNo, @RequestBody Product product) {
        return productService.update(productNo, product);
    }

    @DeleteMapping("/{productNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("productNo") Long productNo) {
        productService.delete(productNo);
    }

}
