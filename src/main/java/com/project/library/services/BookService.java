package com.project.library.services;

import com.project.library.tables.Book;
import com.project.library.tables.Review;

import java.util.Collection;

public interface BookService {
    Book createNewBook(Book book);
    Collection<Book> getAllBooks();
    Collection<Book> findBooksByAuthorOrTitle(String titleOrAuthor);
    Collection<Book> findBooksByAuthor(String author);
    Collection<Book> findBookByIsAvailable(Boolean isAvailable);
    Collection<Book> findBookByCategoryIn(Collection<String> categories);
    Collection<Book> findAllByOrderByAvgStarDesc();
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPage(int pages, int limit);
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPageSortedByFiled(int pages, int limit, String field, Boolean DESC);
    Collection<Review> findReviewsByBookId(Long idBook);
    Book getBookById(Long id);
    Book updateBookById(Book book);
    void deleteBookById(Long id);
}
