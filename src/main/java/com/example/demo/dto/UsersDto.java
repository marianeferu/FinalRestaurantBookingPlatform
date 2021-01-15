package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class UsersDto {

    @NotNull(message = "This field is required")
    private String username;

    @NotNull(message = "This field is required")
    private String password;

    @Size( max = 200)
    private String description;


}
