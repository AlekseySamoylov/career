package com.alekseysamoylov.career.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alekseysamoylov.career.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByName(String name);
}
