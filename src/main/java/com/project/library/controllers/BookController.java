package com.project.library.controllers;

import com.project.library.services.implementation.BookServiceImplementation;
import com.project.library.tables.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImplementation bookServiceImplementation;
    //Get request

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getAllBooks")
    @ResponseBody
    public Collection<Book> getAllBooks(){
        return bookServiceImplementation.getAllBooks();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getBookWithTitleOrAuthorLike")
    @ResponseBody
    public Collection<Book> getBookWithTitleOrAuthorLike(@RequestParam String titleOrAuthor){
        return bookServiceImplementation.findBooksByAuthorOrTitle(titleOrAuthor);
    }
    @GetMapping(path = "/getBookWithAuthorEquals")
    @ResponseBody
    public Collection<Book> getBookWithAuthorEquals(@RequestParam String author){
        return bookServiceImplementation.findBooksByAuthor(author);
    }

    @GetMapping(path = "/getBooksByAvailability")
    @ResponseBody
    public Collection<Book> getBooksByAvailability(@RequestParam Boolean isAvailable){
        return bookServiceImplementation.findBookByIsAvailable(isAvailable);
    }

    @GetMapping(path="/getBooksWithCategoryIn")
    @ResponseBody
    public Collection<Book> getBooksWithCategoryIn(@RequestParam Collection<String> categories){
        return bookServiceImplementation.findBookByCategoryIn(categories);
    }

    @GetMapping(path="/getBooksSortedByAvgStar")
    @ResponseBody
    public Collection<Book> getBooksSortedByAvgStar(){
        return bookServiceImplementation.findAllByOrderByAvgStarDesc();
    }
//POST request
    @PostMapping(path = "/createNewBook")
    public void createNewBook(@RequestBody Book book){
        bookServiceImplementation.createNewBook(book);
    }


//Delete request
    @DeleteMapping(path = "/deleteBookById/{idBook}")
    public void deleteBookById(@PathVariable("idBook") Long id){
        bookServiceImplementation.deleteBookById(id);
    }

}
