package com.project.library.services.implementation;

import com.project.library.repos.BookRepo;
import com.project.library.services.BookService;
import com.project.library.tables.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BookServiceImplementation implements BookService {

    private final BookRepo bookRepo;
    @Override
    public Book createNewBook(Book book) {

        return bookRepo.save(book);
    }
    @Override
    public Collection<Book> getAllBooks(){
        log.info("All books ve been fetched");
        return bookRepo.findAll();
    }

    @Override
    public Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPage(int pages, int limit) {
        log.info("Fetching {} from all books, page {}", limit, pages);
        return bookRepo.findAll(PageRequest.of(pages, limit)).toList();
    }

    @Override
    public Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPageSortedByFiled(int pages, int limit, String field, Boolean DESC) {
        log.info("Fetching {} from all books, page {}", limit, pages);
        return bookRepo.findAll(PageRequest.of(pages, limit).withSort(Sort.by(DESC ? Sort.Direction.DESC : Sort.Direction.ASC, field))).toList();
    }

    @Override
    public Book getBookById(Long id) {
        log.info("Fetching book with id {}",id);
        return bookRepo.findBookByIdBook(id);
    }

    @Override
    public Book updateBookById(Book book) {
        log.info("Updated the book with title {}", book.getTitle());
        return bookRepo.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        log.info("Updated the book with id {}", id);
        boolean exists = bookRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("Book with id "+ id + " doesnt exists");
        }
        bookRepo.deleteById(id);
    }
}
