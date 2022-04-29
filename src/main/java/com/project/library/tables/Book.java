package com.project.library.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(
            unique=true,
            nullable=false
    )
    private Long idBook;

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
            columnDefinition = "FLOAT"
    )
    private Float avgStar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentedBy", referencedColumnName = "idUsers")
    private Users users;

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;


    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", img_paths='" + img_paths + '\'' +
                ", image='" + image + '\'' +
                ", isAvailable=" + isAvailable +
                ", avgStar=" + avgStar +
                ", users=" + users +
                '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg_paths() {
        return img_paths;
    }

    public void setImg_paths(String img_paths) {
        this.img_paths = img_paths;
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
}
