package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.exceptions.UserExistsException;
import com.example.demo.mappers.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    private UsersMapper usersMapper;


    public UsersController(UsersService usersService, UsersMapper usersMapper) {
        this.usersService = usersService;
        this.usersMapper = usersMapper;
    }


    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody @Valid RegisterDto usersDto){

            Users savedUsers = usersService.register(usersMapper.usersDtoToUsers(usersDto));
            return ResponseEntity.ok().body(savedUsers);

    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody @Valid LoginDto usersDto){

        Users savedUsers = usersService.login(usersMapper.usersDtoToUsers(usersDto));
        return ResponseEntity.ok().body(savedUsers);

    }


}
