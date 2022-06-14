package com.project.library.services;

import com.project.library.tables.Borrow;
import com.project.library.tables.Review;

import java.util.Collection;

public interface BorrowService {
    Borrow createNewBorrow(Borrow borrow);
    Collection<Borrow> getAllBorrow();


}
