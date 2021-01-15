package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConfirmedReservDto {

    @NotNull
    private String user_reserv;

    @NotNull
    private String conf_reserv_id;


}
