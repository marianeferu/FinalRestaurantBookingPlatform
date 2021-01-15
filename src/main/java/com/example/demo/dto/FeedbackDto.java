package com.example.demo.dto;

import com.example.demo.model.Reservation;
import com.example.demo.model.Users;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackDto {

    @NotNull
    private Reservation reservation;

    @NotNull
    private Users user_feedback; // user's id

    @Size( max = 200)
    private String comment;

    @Max(5)
    private Integer stars; // out of 5

}
