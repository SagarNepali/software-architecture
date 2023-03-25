package com.example.ProductService.dao;

import com.example.ProductService.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    public static List<Product> productInventory;

    static {
        productInventory = new ArrayList<>() {{
           add(new Product().builder()
                   .productNo(1L)
                   .name("IPhone")
                   .build()) ;
            add(new Product().builder()
                    .productNo(2L)
                    .name("Acer")
                    .build()) ;
            add(new Product().builder()
                    .productNo(3L)
                    .name("Marlboro")
                    .build()) ;
            add(new Product().builder()
                    .productNo(4L)
                    .name("Coke")
                    .build()) ;
            add(new Product().builder()
                    .productNo(5L)
                    .name("Pringles")
                    .build()) ;
        }};
    }

    @Override
    public Product getProduct(Long productNo) {
        return productInventory.stream()
                .filter(p -> p.getProductNo().equals(productNo)).findAny().orElse(null);
    }
}
