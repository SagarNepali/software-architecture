package webshop.components.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.components.product.service.ProductCatalogService;
import webshop.components.shoppingcart.model.ShoppingCart;
import webshop.components.shoppingcart.repository.ShoppingCartDAO;

@Service
public class ShoppingCartService {

    @Autowired
    ProductCatalogService productCatalogService;

    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    public ShoppingCart addToShoppingCart(Long cartId, ProductDTO productDTO, Integer quantity){
        //need to change the implementation
        shoppingCartDAO.save(cart);
        return cart;
    }

    public ShoppingCart getShoppingCart(Long cartId) {
        return shoppingCartDAO.findById(cartId).orElse(null);
    }

}
