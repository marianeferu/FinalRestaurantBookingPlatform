package com.example.demo.mappers;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.model.Users;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UsersMapper {

    public Users usersDtoToUsers(@Valid RegisterDto usersDto) {
        return new Users(usersDto.getUsername(),usersDto.getPassword());
    }

    public Users usersDtoToUsers(@Valid LoginDto usersDto) {
        return new Users(usersDto.getUsername(),usersDto.getPassword());
    }

    //  public Users registerUsersDtoToUsers(RegisterDto registerDto) {
   //     return new Users(registerDto.getId(), registerDto.getUsername(), registerDto.getPassword(), registerDto.getDescription());
  //  }
}