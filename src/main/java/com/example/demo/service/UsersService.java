package com.example.demo.service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.exceptions.UserExistsException;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {



    @Autowired
    private UsersRepository usersRepository;
    public Users register(Users users) {
        Optional<Users> usersWithSameUsername = usersRepository.getByUsername(users.getUsername());
        if (usersWithSameUsername.isPresent()) {
            throw new UserExistsException();
        }
        return usersRepository.register(users);
    }

    public boolean existsById(long id) {
        return usersRepository.existsById(id);
    }

    public Users login(Users users) {
        Optional<Users> usersWithSameUsername = usersRepository.getByUsername(users.getUsername());
        if (usersWithSameUsername.isPresent()) {
            throw new UserExistsException();
        }
        return usersRepository.login(users);
    }


}

