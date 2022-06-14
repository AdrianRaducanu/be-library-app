package com.project.library.services.implementation;

import com.project.library.repos.ReviewRepo;
import com.project.library.services.ReviewService;
import com.project.library.tables.Review;
import com.project.library.tables.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public Collection<Review> findAllByBook(Long idBook) {
        return reviewRepo.findAllByBook_IdBook(idBook);
    }

    @Override
    public Collection<Review> findAllByUser(Long idUser) {
        return reviewRepo.findAllByUsers_IdUsers(idUser);
    }

    @Override
    public Users findUserByReviewId(Long idReview){
        Review rev = reviewRepo.findReviewByIdReview(idReview);
        return rev.getUsers();
    }



}
