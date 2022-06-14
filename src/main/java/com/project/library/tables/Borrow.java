package com.project.library.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Borrow")
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    @Id
    @SequenceGenerator(
            name = "borrow_sequence",
            sequenceName = "borrow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "borrow_sequence"
    )
    private Long idBorrow;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsers", referencedColumnName = "idUsers")
    private Users users;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBook", referencedColumnName = "idBook")
    private Book book;

    @Column(
            columnDefinition = "DATE"
    )
    private LocalDateTime borrowDate;

    @Column(
            columnDefinition = "DATE"
    )
    private LocalDateTime dueDate;

    public Long getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

}
