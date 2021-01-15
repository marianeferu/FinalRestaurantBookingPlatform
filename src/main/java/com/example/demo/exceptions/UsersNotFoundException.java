package com.example.demo.exceptions;

import com.example.demo.model.Users;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Users usersId) {
        super("User with id " + usersId + " doesn't exist.");
    }
}
