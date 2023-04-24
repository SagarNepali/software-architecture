package product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import product.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    Product findProductByProductNo(Long productNo);
}

