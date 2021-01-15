package com.example.demo.mappers;

import com.example.demo.dto.ReservationDto;
import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ReservationMapper {

    public Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        return new Reservation(reservationDto.getUser(), reservationDto.getDate(),reservationDto.getDetails_menu(), reservationDto.getNum_tables(),reservationDto.getNum_persons(), reservationDto.isConfirmed_reserv(), reservationDto.getPayment_method());

    }

}
