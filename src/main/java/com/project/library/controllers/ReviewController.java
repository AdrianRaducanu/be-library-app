package com.project.library.controllers;

import com.project.library.repos.BookRepo;
import com.project.library.repos.ReviewRepo;
import com.project.library.services.implementation.BookServiceImplementation;
import com.project.library.services.implementation.ReviewServiceImplementation;
import com.project.library.services.implementation.UsersServiceImplementation;
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
    private final ReviewRepo reviewRepo;
    private final BookServiceImplementation bookServiceImplementation;
    private final UsersServiceImplementation usersServiceImplementation;
    private final BookRepo bookRepo;

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

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getBookByReviewId")
    @ResponseBody
    public Book findBookByReviewId(@RequestParam Long idReview){
        return reviewServiceImplementation.findBookByReviewId(idReview);
    }

    @CrossOrigin( origins = "http://localhost:4200")
    @PostMapping(path = "/saveReview")
    @ResponseBody
    public void createReview(@RequestParam Long idBook, @RequestParam Long idUser, @RequestBody Review review){
        Book bookForReview = bookServiceImplementation.getBookById(idBook);
        Users userForReview = usersServiceImplementation.findUserById(idUser);
        review.setBook(bookForReview);
        review.setUsers(userForReview);
        reviewRepo.save(review);
        Collection<Review> revs = reviewServiceImplementation.findAllByBook(idBook);
        Float sum = 0F;
        for(Review r : revs){
            sum += r.getStars();
        }
        float returnStar = (float)Math.round(sum/revs.size());
        bookForReview.setAvgStar(returnStar);
        bookRepo.save(bookForReview);
    }

    @GetMapping(path = "/allReview")
    @ResponseBody
    public Collection<Review> findAll(){
        return reviewRepo.findAll();
    }

}
