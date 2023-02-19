package books.controller;


import books.domain.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book add(@RequestBody Book b) {
        return bookService.addBook(b);
    }

    @PutMapping("/{isbn}")
    public Book update(@RequestBody Book b, @PathVariable String isbn) {
        return bookService.updateBook(b, isbn);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }
}
