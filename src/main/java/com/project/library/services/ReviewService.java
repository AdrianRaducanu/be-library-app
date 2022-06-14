package com.project.library.services;

import com.project.library.tables.Book;
import com.project.library.tables.Review;
import com.project.library.tables.Users;
import org.apache.catalina.User;

import java.util.Collection;

public interface ReviewService {

    Collection<Review> findAllByBook(Long idBook);
    Users findUserByReviewId(Long idReview);
    Collection<Review> findAllByUser(Long idUser);
    Book findBookByReviewId(Long idReview);
}
