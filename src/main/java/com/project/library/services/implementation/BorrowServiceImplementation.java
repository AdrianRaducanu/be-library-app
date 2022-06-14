package com.project.library.services.implementation;

import com.project.library.repos.BookRepo;
import com.project.library.repos.BorrowRepo;
import com.project.library.services.BorrowService;
import com.project.library.tables.Borrow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BorrowServiceImplementation implements BorrowService {

    private final BorrowRepo borrowRepo;

    @Override
    public Borrow createNewBorrow(Borrow borrow) {
        borrowRepo.save(borrow);
        return borrow;
    }

    @Override
    public Collection<Borrow> getAllBorrow() {
        return borrowRepo.findAll();
    }
}
