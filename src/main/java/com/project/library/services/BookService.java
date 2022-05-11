package com.project.library.services;

import com.project.library.tables.Book;

import java.util.Collection;

public interface BookService {
    Book createNewBook(Book book);
    Collection<Book> getAllBooks();
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPage(int pages, int limit);
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPageSortedByFiled(int pages, int limit, String field, Boolean DESC);
    Book getBookById(Long id);
    Book updateBookById(Book book);
    void deleteBookById(Long id);
}
