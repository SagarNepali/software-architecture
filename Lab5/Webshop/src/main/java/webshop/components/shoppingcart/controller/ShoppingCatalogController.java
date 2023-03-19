package webshop.components.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webshop.components.shoppingcart.model.ShoppingCart;
import webshop.components.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCatalogController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/{cartId}")
    ShoppingCart getCart(@PathVariable("cartId")Long cartId) {
        return shoppingCartService.getShoppingCart(cartId);
    }

    @PostMapping("/{cartId}/{quantity}")
    public void addToCart(@PathVariable Long cartId, @PathVariable Integer quantity, @RequestBody ProductDTO productDTO ) {
        shoppingCartService.addToShoppingCart(cartId, productDTO, quantity);
    }
}
