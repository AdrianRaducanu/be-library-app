package com.project.library;

import com.project.library.repos.BookRepo;
import com.project.library.repos.ReviewRepo;
import com.project.library.repos.UsersRepo;
import com.project.library.tables.Book;
import com.project.library.tables.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(BookRepo bookRepo, UsersRepo usersRepo, ReviewRepo reviewRepo){
		return args -> {

			List<Book> b1 = bookRepo.findBookByAuthor("Adam Kay");
			Book b2 = bookRepo.findBookByIdBook(3L);
			System.out.println(b2);

		};

	}
 */
}
