package books.controller;


import books.domain.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book add(@RequestBody Book b) {
        return bookService.addBook(b);
    }

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book b, @PathVariable String isbn) {
        return bookService.updateBook(b, isbn);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }
}
