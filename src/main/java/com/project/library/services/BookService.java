package com.project.library.services;

import com.project.library.tables.Book;

import java.util.Collection;

public interface BookService {
    Book create(String title, String author, String category, String description, String imgPaths, String image);
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPage(int pages, int limit);
    Collection<Book> bookPaginationWithPageAsNoOfPagesAndLimitAsElementsOnPageSortedByFiled(int pages, int limit, String field, Boolean DESC);
    Book get(Long id);
    Book update(Book book);
    Boolean delete(Long id);
}
