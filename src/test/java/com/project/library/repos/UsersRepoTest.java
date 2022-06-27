package com.project.library.repos;

import com.project.library.tables.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsersRepoTest {

    @Autowired
    private UsersRepo usersRepo;
    @Test
    void shouldFindUsersByEmail() {
        //proprietatile initializate
        String emailToCheck = "test@java.com";
        Users u = new Users();
        u.setEmail(emailToCheck);
        u.setFirstName("Testing");
        u.setLastName("Unit");
        u.setPassword("123");
        u.setPhone("0119921");
        usersRepo.save(u); //instanta serviciul injectat si adnotat cu @Autowired

        //executarea metodei
        Users expectedUsers = usersRepo.findUsersByEmail(emailToCheck);

        //verificarea functionalitatii metodei
        assertThat(expectedUsers.getFirstName()).isEqualTo("Testing");
    }
}