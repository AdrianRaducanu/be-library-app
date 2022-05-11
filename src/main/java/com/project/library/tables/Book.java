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
    private String imgPath;

    @Column(
            columnDefinition = "TEXT"
    )
    private String image;

    @Column(
            columnDefinition = "BOOLEAN"
    )
    private Boolean isAvailable;

    @Column(
            columnDefinition = "FLOAT"
    )
    private Float avgStar = 0F;

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Float getAvgStar() {
        return avgStar;
    }

    public void setAvgStar(Float avgStar) {
        this.avgStar = avgStar;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
