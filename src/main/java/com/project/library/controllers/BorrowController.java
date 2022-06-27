package com.project.library.controllers;

import com.project.library.repos.BorrowRepo;
import com.project.library.services.implementation.BookServiceImplementation;
import com.project.library.services.implementation.BorrowServiceImplementation;
import com.project.library.services.implementation.UsersServiceImplementation;
import com.project.library.tables.Book;
import com.project.library.tables.Borrow;
import com.project.library.tables.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowServiceImplementation borrowServiceImplementation;
    private final BookServiceImplementation bookServiceImplementation;
    private final UsersServiceImplementation usersServiceImplementation;
    private final BorrowRepo borrowRepo;


    @GetMapping(path = "/getAllBorrow")
    @ResponseBody
    public Collection<Borrow> getAllBorrows(){
        return borrowServiceImplementation.getAllBorrow();
    }

    @CrossOrigin( origins = "http://localhost:4200")
    @PostMapping(path = "/saveBorrow")
    @ResponseBody
    public void createNewBorrow(@RequestParam Long idBook, @RequestParam Long idUser){
        Borrow b = new Borrow();
        b.setBorrowDate(LocalDateTime.now());
        b.setDueDate(LocalDateTime.of(b.getBorrowDate().getYear(), b.getBorrowDate().getMonth(), b.getBorrowDate().getDayOfMonth() + 4, b.getBorrowDate().getHour(), b.getBorrowDate().getMinute()) );
        b.setBook(bookServiceImplementation.getBookById(idBook));
        b.setUsers(usersServiceImplementation.findUserById(idUser));
        borrowServiceImplementation.createNewBorrow(b);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getBorrowByIdBorrow")
    @ResponseBody
    public Borrow getBorrowByIdBorrow(@RequestParam Long idBorrow){
        return borrowRepo.findBorrowByIdBorrow(idBorrow);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getBorrowByIdUser")
    @ResponseBody
    public Borrow getBorrowByIdUsers(@RequestParam Long idUsers){
        Borrow bnull  = new Borrow();
        Collection<Borrow> b =  borrowRepo.findBorrowByUsersIdUsersOrderByIdBorrowDesc(idUsers);
        if(b.size()> 0){
            return b.iterator().next();
        }else return bnull;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getBorrowByIdBook")
    @ResponseBody
    public Borrow getBorrowByIdBook(@RequestParam Long idBook){
        Borrow bnull  = new Borrow();
        Collection<Borrow> b =  borrowRepo.findBorrowByBookIdBookOrderByIdBorrowDesc(idBook);
        if(b.size()> 0){
            return b.iterator().next();
        }else return bnull;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getBookByIdBorrow")
    @ResponseBody
    public Book getBookByIdBorrow(@RequestParam Long idBorrow){
        Borrow b = borrowRepo.findBorrowByIdBorrow(idBorrow);
        return b.getBook();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/deleteByIdBorrow")
    @ResponseBody
    public void deleteBorrow(@RequestParam Long idBorrow){
        borrowRepo.deleteById(idBorrow);
    }
}
