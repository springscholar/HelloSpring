package com.hr.learning.projectbackend.repository;

import com.hr.learning.projectbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
