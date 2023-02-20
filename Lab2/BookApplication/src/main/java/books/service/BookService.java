package books.service;

import books.domain.Book;
import books.integration.JmsSender;
import books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    JmsSender jmsSender;

    public Book addBook(Book book) {
        Book b = bookRepository.add(book);
        jmsSender.sendMessage(book);
        return b;

    }

    public Book updateBook(Book book, String isbn) {
        Book b = bookRepository.update(book);
        jmsSender.sendMessage(b);
        return b;
    }

    public void deleteBook(String isbn) {
        Book b = bookRepository.get(isbn);
        bookRepository.delete(isbn);
        jmsSender.sendMessage(b);
    }

    public Book getBook(String isbn) {
        Book b = bookRepository.get(isbn);
        jmsSender.sendMessage(b);
        return b;
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.getAll();
    }


}
