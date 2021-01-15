package com.example.demo.controller;

import com.example.demo.dto.ConfirmedReservDto;
import com.example.demo.dto.ReservationDto;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private ReservationMapper reservationMapper;


    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping
    private ResponseEntity<Reservation> createReservation(@RequestBody @Valid ReservationDto reservationDto){

            Reservation savedReservation = reservationService.createReservation(reservationMapper.reservationDtoToReservation(reservationDto));
            return ResponseEntity.ok().body(savedReservation);
        }


    @GetMapping("/history")
    public List<Reservation> getReservations(@RequestBody long usersId) {
        return reservationService.getByUsersId(usersId);
    }


    @PostMapping("/confirm")
    private ResponseEntity<Object>confirm(@RequestBody @Valid ConfirmedReservDto confirmedReservDto){

            reservationService.confirm(confirmedReservDto);
            return ResponseEntity.ok().body("Reservation confirmed");


    }

    @DeleteMapping("/cancel")
    private ResponseEntity<Object>cancel(@RequestBody @Valid ConfirmedReservDto confirmedReservDto){

            reservationService.cancel(confirmedReservDto);
            return  ResponseEntity.ok().body("Reservation canceled");

    }

/// report feature


    @GetMapping("/reports")
    public List<Reservation> getallReservations() {
        return reservationService.getallReservations();
    }

    @GetMapping("/feedbacks")
    public List<Reservation> getallFeedbacks() {
        return reservationService.getallFeedbacks();
    }


    }




