package com.alekseysamoylov.career.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alekseysamoylov.career.security.entity.User;
import com.alekseysamoylov.career.security.repository.UserRepository;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean processUser(String name) throws IllegalArgumentException {
        User user = userRepository.findOneByName(name);

        if (user == null) {
            throw new IllegalArgumentException("Something was wrong with username");
        }
        return true;
    }


    public int sum(int a, int b) {
        return a + b;
    }

}
