package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.domain.Product;
import product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long productNo, Product product) {
        Product data = findById(productNo);
        if(data !=null) {
            productRepository.save(product);
        }else{
            throw new IllegalArgumentException("No product found of id: "+productNo);
        }
        return product;
    }

    public void delete(Long productNo) {
        Product product  = findById(productNo);
        if(product != null) {
            productRepository.delete(product);
        }else{
            throw new IllegalArgumentException("No product found of id: "+productNo);
        }
    }

    public Product findById(Long productNo) {
        return productRepository.findProductByProductNo(productNo);
    }
}
