package webshop.components.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    Stock stock;
    Supplier supplier;
    Review review;
}
