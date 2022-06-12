package com.project.library.services;

import com.project.library.tables.Users;

import java.util.Collection;

public interface UsersService {
    Users createNewUser(Users users);
    Collection<Users> getAllUsers();
    Collection<Users> findUsersByFirstNameAndLastName(String firstName, String lastName);
    Users findUserByEmail(String email);
    Users findUserById(Long id);
}
