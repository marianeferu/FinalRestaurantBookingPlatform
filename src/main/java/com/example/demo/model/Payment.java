package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class Payment {

    private int id;
    private String payment_method;


}
