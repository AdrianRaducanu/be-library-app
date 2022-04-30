package com.project.library;

import com.project.library.repos.BookRepo;
import com.project.library.tables.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookRepo bookRepo){
		return args -> {

			bookRepo.deleteById(11480L);

		};

	}



}
