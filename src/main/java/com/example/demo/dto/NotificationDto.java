package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.demo.model.Users;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

    //@NotNull(message = "Id is required")
    //private int id;

    @Size( max = 50)
    private String message;

    @NotNull(message = "Date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:MM:SS")
    private Date date;

    @NotNull(message = "User is required")
    private Users user;


}
