package com.project.library.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    private Long idBook;

    @OneToOne(mappedBy = "book")
    private Borrow borrow;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            columnDefinition = "TEXT"
    )
    private String author;

    @Column(
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String category;

    @Column(
            columnDefinition = "TEXT"
    )
    private String img_paths;

    @Column(
            columnDefinition = "TEXT"
    )
    private String image;

    @Column(
            columnDefinition = "BOOLEAN"
    )
    private Boolean isAvailable;

    @Column(
            columnDefinition = "FLOAT",
            nullable = false
    )
    private Float avgStar;

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;



}
