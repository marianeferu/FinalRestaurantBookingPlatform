package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class Feedback {

    private int id;
    private Reservation reservation;
    private Users user_feedback;
    private String comment;
    private Integer stars; // out of 5

}
