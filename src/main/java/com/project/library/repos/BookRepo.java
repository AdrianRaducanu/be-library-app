package com.project.library.repos;

import com.project.library.tables.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Book findBookByIdBook(Long idBook);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByCategoryIn(Collection<String> categories);
    List<Book> findBookByAuthor(String author);
    List<Book> findBookByIsAvailable(Boolean isAvailable);
    List<Book> findBookByAvgStarGreaterThanEqual(Float avgStar);
    List<Book> findBookByAvgStarLessThanEqual(Float avgStar);


}
