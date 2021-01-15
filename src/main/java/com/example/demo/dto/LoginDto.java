package com.example.demo.dto;

import com.example.demo.validators.OnlyLetters;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {

    @NotNull(message = "Field is required")
    @Size( max = 20, message = "Max 20 letters")
    @OnlyLetters
    private String username;

    @Size( min = 6, message = "Password needs min 6 characters")
    @NotNull(message = "Field is required")
    private String password;


}
