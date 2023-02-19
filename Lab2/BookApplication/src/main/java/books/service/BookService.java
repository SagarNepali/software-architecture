package books.service;

import books.domain.Book;
import books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.add(book);
    }

    public Book updateBook(Book book, String isbn) {
        return bookRepository.update(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.delete(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.get(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }


}
