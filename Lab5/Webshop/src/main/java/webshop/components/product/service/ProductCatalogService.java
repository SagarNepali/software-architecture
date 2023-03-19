package webshop.components.product.service;

import webshop.components.product.repository.ProductDAO;
import webshop.components.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogService {

    @Autowired
    ProductDAO productDAO;

    public Product getProductById(Long id) {
        return productDAO.findById(id).get();
    }

    public List<Product> getAll() {
        return  productDAO.findAll();
    }

    public Product addProduct(Product p) {
        productDAO.save(p);
        return p;
    }

}
