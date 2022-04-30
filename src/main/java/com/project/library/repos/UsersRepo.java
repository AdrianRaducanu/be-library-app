package com.project.library.repos;

import com.project.library.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
}
