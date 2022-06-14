package com.project.library.repos;

import com.project.library.tables.Book;
import com.project.library.tables.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAllByBook_IdBook(Long idBook);
    List<Review> findAllByUsers_IdUsers(Long idUser);
    Review findReviewByIdReview(Long idReview);

}
