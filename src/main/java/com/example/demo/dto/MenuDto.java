package com.example.demo.dto;

import com.example.demo.validators.OnlyLetters;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MenuDto {

    @NotNull(message = "Field is required")
    @OnlyLetters
    private String name;

    @NotNull
    private Integer starting_price; // 0 for normal booking, 100 for an all inclusive event

}
