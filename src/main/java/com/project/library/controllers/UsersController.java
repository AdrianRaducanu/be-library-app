package com.project.library.controllers;

import com.project.library.services.implementation.UsersServiceImplementation;
import com.project.library.tables.Users;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersServiceImplementation usersServiceImplementation;

    @CrossOrigin(origins = "http://localhost:4200/")

    @GetMapping(path = "/getAllUsers")
    @ResponseBody
    public Collection<Users> getAllBooks(){
        return usersServiceImplementation.getAllUsers();
    }

}
