package webshop.components.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.components.shoppingcart.model.ShoppingCart;

@Repository
public interface ShoppingCartDAO extends MongoRepository<ShoppingCart, Long> {
}
