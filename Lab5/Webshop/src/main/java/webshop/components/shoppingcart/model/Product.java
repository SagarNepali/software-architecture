package webshop.components.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webshop.components.product.model.Review;
import webshop.components.product.model.Stock;
import webshop.components.product.model.Supplier;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    Long productNo;
    String description;
    Double price;
}
