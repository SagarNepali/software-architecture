package webshop.components.product.repository;

import webshop.components.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends MongoRepository<Product,Long> {
}
