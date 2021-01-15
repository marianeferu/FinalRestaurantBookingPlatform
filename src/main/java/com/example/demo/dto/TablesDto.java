package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TablesDto {

    @NotNull(message = "Number of persons is required")
    @Min(1)
    @Max(10)
    private int number_of_persons;
}
