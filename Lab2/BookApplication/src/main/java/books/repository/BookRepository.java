package books.repository;

import books.domain.Book;

import java.util.List;

public interface BookRepository {

    Book add(Book book);
    Book update(Book book);
    void delete(String isbn);
    Book get(String isbn);
    List<Book> getAll();
}
