package webshop.components.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webshop.components.product.model.Product;
import webshop.components.product.service.ProductCatalogService;

@RestController
@RequestMapping(value = "/api/product")
public class ProductCatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    @PostMapping
    Product addProduct(@RequestBody Product product) {
        return productCatalogService.addProduct(product);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable("id") Long id) {
        return productCatalogService.getProductById(id);
    }
}
