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
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "review_sequence"
    )
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
