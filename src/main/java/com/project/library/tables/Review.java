package com.project.library.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;

    @Column(
            columnDefinition = "TEXT"
    )
    private String fullReview;

    @Column(
            columnDefinition = "TEXT"
    )
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "idBook")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users users;

}
