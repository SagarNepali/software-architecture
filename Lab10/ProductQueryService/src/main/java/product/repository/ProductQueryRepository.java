package product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import product.domain.Product;

@Repository
public interface ProductQueryRepository extends MongoRepository<Product, Long> {

    Product findProductByProductNo(Long productNo);
}

