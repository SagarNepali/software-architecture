package books.repository;

import books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static List<Book> books;


    static {
        books = new ArrayList<>(){{
            add(new Book("A1","Mr.A","A title",2.99));
            add(new Book("B1","Mr.B","B title",12.99));
            add(new Book("C1","Mr.C","C title",22.99));
            add(new Book("D1","Mr.D","D title",200.99));

        }};
    }

    @Override
    public Book add(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
       Book b = get(book.getIsbn());
       b.setAuthor(book.getAuthor());
       b.setPrice(book.getPrice());
       b.setTitle(book.getTitle());
       delete(book.getIsbn());
       books.add(b);
       return book;
    }

    @Override
    public void delete(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public Book get(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }
}
