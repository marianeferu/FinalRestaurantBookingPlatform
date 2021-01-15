package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDto {

    @NotNull(message = "Type of payment is required")
    @Size( max = 50)
    private String payment_method;


}
