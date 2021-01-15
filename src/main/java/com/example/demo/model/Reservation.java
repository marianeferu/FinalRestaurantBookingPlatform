package com.example.demo.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {

    private int id;
    private Users user;
    private Date date; //+time
    private Menu details_menu;
    private Tables num_tables;
    private int num_persons;
    private boolean confirmed_reserv;
    private Payment payment_method;


    public Reservation(Users user, Menu details_menu, Tables num_tables, int num_persons, boolean confirmed_reserv, Payment payment_method) {
        this.user = user;
        this.details_menu = details_menu;
        this.num_tables = num_tables;
        this.num_persons = num_persons;
        this.confirmed_reserv = confirmed_reserv;
        this.payment_method = payment_method;
    }

    public Reservation(Users user, Date date, Menu details_menu, Tables num_tables, Integer num_persons, boolean confirmed_reserv, Payment payment_method) {
        this.user = user;
        this.date = date;
        this.details_menu = details_menu;
        this.num_tables = num_tables;
        this.num_persons = num_persons;
        this.confirmed_reserv = confirmed_reserv;
        this.payment_method = payment_method;
    }

    public Reservation(Users user, boolean confirmed_reserv) {
        this.user = user;
        this.confirmed_reserv = confirmed_reserv;
    }


    public Reservation(Object user, boolean confirmed_reserv) {
    }

    public Reservation(int id, String user, boolean confirmed_reserv) {
    }
}
