package webshop.components.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ShoppingCart {

    @Id
    Long cartId;
    List<CartLine> cartLines;

}
