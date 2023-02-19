package books.controller;


import books.domain.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book update(@RequestBody Book b, @PathVariable String isbn) {
        return bookService.updateBook(b, isbn);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }

    @GetMapping
    public Collection<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }
}
