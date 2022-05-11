package com.project.library.controllers;

import com.project.library.services.implementation.BookServiceImplementation;
import com.project.library.tables.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImplementation bookServiceImplementation;

    @GetMapping(path = "/getAllBooks")
    public Collection<Book> getBooks(){
        return bookServiceImplementation.getAllBooks();
    }

    @PostMapping(path = "/createNewBook")
    public void createNewBook(@RequestBody Book book){
        bookServiceImplementation.createNewBook(book);
    }

    @DeleteMapping(path = "/deleteBookById/{idBook}")
    public void deleteBookById(@PathVariable("idBook") Long id){
        bookServiceImplementation.deleteBookById(id);
    }

}
