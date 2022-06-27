package com.project.library.controllers;

import com.project.library.repos.UsersRepo;
import com.project.library.services.implementation.Encoder;
import com.project.library.services.implementation.UsersServiceImplementation;
import com.project.library.tables.Users;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersServiceImplementation usersServiceImplementation;
    private final Encoder encoder;
    private final UsersRepo usersRepo;


    @GetMapping(path = "/getAllUsers")
    @ResponseBody
    public Collection<Users> getAllBooks(){
        return usersServiceImplementation.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/auth")
    @ResponseBody
    public Boolean authUser(@RequestParam String email,@RequestParam String password){
        Users u = usersRepo.findUsersByEmail(email);
        return encoder.decodePass(u.getPassword(),password);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/getUserByEmail")
    @ResponseBody
    public Users getUserByEmail(@RequestParam String email){
        return usersRepo.findUsersByEmail(email);
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(path = "/saveUser")
    @ResponseBody
    public Users createNewUser(@RequestBody Users users){
        users.setPassword(encoder.encodePass(users.getPassword()));
        usersRepo.save(users);
        return users;
    }

}
