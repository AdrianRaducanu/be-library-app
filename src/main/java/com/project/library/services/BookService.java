package com.project.library.services;

import com.project.library.tables.Book;

import java.util.Collection;

public interface BookService {
    Book create(Book book);
    Collection<Book> listBook(int limit);
    Book get(Long id);
    Book update(Book book);
    Boolean delete(Long id);
}
