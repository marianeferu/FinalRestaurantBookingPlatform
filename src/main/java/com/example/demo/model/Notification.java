package com.example.demo.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private int id;
    private String message;
    private Date date;
    private Users user;


    public Notification(String message, Date date, Users user) {
        this.message = message;
        this.date = date;
        this.user = user;
    }
}
