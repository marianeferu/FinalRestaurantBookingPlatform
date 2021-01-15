package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;
    @InjectMocks
    private UsersService usersService;

    @Test
    void register() {

        Users users = new Users("Ramon", "pass123");
        Users savedUsers = new Users(0,"Ramon", "pass123");
        when(usersRepository.getByUsername(any())).thenReturn(Optional.empty());
        when(usersRepository.register(any())).thenReturn(savedUsers);

        Users result = usersService.register(users);

        assertEquals(users.getId(), result.getId());
        assertEquals(users.getUsername(), result.getUsername());
        assertEquals(users.getPassword(), result.getPassword());
        assertEquals(0, result.getId());

        verify(usersRepository).getByUsername(any());
        verify(usersRepository).register(any());

    }
}