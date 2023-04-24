package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.domain.Product;
import product.repository.ProductQueryRepository;

import java.util.List;

@Service
public class ProductQueryService {

    @Autowired
    ProductQueryRepository productRepository;

    public Product findById(Long productNo) {
        return productRepository.findProductByProductNo(productNo);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
