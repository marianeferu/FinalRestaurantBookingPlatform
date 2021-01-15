package com.example.demo.dto;

import com.example.demo.model.Menu;
import com.example.demo.model.Payment;
import com.example.demo.model.Tables;
import com.example.demo.model.Users;
import com.example.demo.validators.OnlyLetters;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReservationDto {

    @Size(min = 5, max = 50)
    @NotNull(message = "This field is required")
    private Users user;


    @Future
    @NotNull(message = "Date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH")
    private Date date;


    private Menu details_menu;

    @Max(20)
    @Min(1)
    private int num_persons;

    @Max(50)
    @NotNull(message = "This field is required")
    private Tables num_tables;



    //@AssertTrue
    private boolean confirmed_reserv;

    @OnlyLetters
    private Payment payment_method;



}
