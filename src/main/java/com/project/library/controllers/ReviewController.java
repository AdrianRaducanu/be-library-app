package com.project.library.controllers;

import com.project.library.services.implementation.ReviewServiceImplementation;
import com.project.library.tables.Book;
import com.project.library.tables.Review;
import com.project.library.tables.Users;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImplementation reviewServiceImplementation;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getReviewsByIdBook")
    @ResponseBody
    public Collection<Review> findAllByBook(@RequestParam Long idBook){
        return reviewServiceImplementation.findAllByBook(idBook);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getReviewsByIdUser")
    @ResponseBody
    public Collection<Review> findAllByUser(@RequestParam Long idUser){
        return reviewServiceImplementation.findAllByUser(idUser);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getUserByReviewId")
    @ResponseBody
    public Users findUserByReviewId(@RequestParam Long idReview){
        return reviewServiceImplementation.findUserByReviewId(idReview);
    }
}
