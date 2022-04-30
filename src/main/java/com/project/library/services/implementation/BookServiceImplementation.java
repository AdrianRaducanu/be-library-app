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
    public Book create(String title, String author, String category, String description, String imgPath, String image) {
        Book newBook = new Book();
        newBook.setAvgStar(0F);
        newBook.setCategory(category);
        newBook.setTitle(title);
        newBook.setAvailable(Boolean.TRUE);
        newBook.setDescription(description);
        newBook.setImgPath(imgPath);
        newBook.setImage(image);
        newBook.setAuthor(author);
        log.info("New book created: {}", title);
        return bookRepo.save(newBook);
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
    public Book get(Long id) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
