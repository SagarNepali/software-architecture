package books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private String isbn;
    private String author;
    private String title;
    private Double price;
}
