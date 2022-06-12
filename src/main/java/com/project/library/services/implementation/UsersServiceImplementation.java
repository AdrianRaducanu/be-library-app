package com.project.library.services.implementation;

import com.project.library.repos.UsersRepo;
import com.project.library.services.UsersService;
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

public class UsersServiceImplementation implements UsersService {

    private final UsersRepo usersRepo;
    @Override
    public Users createNewUser(Users users) {
        return usersRepo.save(users);
    }

    @Override
    public Collection<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Collection<Users> findUsersByFirstNameAndLastName(String firstName, String lastName) {
        return usersRepo.findUsersByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Users findUserByEmail(String email) {
        return usersRepo.findUsersByEmail(email);
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepo.findUsersByIdUsers(id);
    }
}
