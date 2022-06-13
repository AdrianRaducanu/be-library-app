package com.project.library.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            unique=true,
            nullable=false
    )
    private Long idUsers;

    @JsonIgnore
    @OneToOne(mappedBy = "users")
    private Borrow borrow;


    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<Review> reviews;

    public Long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
