package com.project.library.repos;

import com.project.library.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UsersRepo extends JpaRepository<Users, Long> {

    Users findUsersByIdUsers(Long id);
    Users findUsersByEmail(String email);
    Collection<Users> findUsersByFirstNameAndLastName(String firstName, String lastName);
}
