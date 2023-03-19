package webshop;

public class ProductDTO {

    Long id;
    String name;
    Double price;

    public ProductDTO(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }
}
