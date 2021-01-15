package com.example.demo.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    private int id;
    private String username;
    private String password;
    private String description;
    private Reservation reservation_user;
    private List<Reservation> history_reservation;
    private boolean user_role; // 0 - client user, 1 - employee


    public Users(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Users(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
