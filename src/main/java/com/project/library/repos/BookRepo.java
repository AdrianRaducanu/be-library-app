package com.project.library.repos;

import com.project.library.tables.Book;
import com.project.library.tables.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Book findBookByIdBook(Long idBook);
    List<Book> findBookByCategoryIn(Collection<String> categories);


    List<Book> findBookByIsAvailable(Boolean isAvailable);
    List<Book> findAllByOrderByAvgStarDesc();


    @Query("SELECT b FROM Book b WHERE b.author like %:titleOrAuthor% OR b.title like %:titleOrAuthor%")
    List<Book> findBooksByAuthorOrTitle(String titleOrAuthor);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findBooksByAuthor(String author);




}
