package com.project.library.repos;

import com.project.library.tables.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {
    Borrow findBorrowByIdBorrow(Long idBorrow);
    Collection<Borrow> findBorrowByUsersIdUsersOrderByIdBorrowDesc(Long idUsers);
    Collection<Borrow> findBorrowByBookIdBookOrderByIdBorrowDesc(Long idBook);
}
