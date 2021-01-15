package com.example.demo.service;

import com.example.demo.dto.ConfirmedReservDto;
import com.example.demo.exceptions.UsersNotFoundException;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {


    private ReservationRepository reservationRepository;
    private UsersService usersService;

    public ReservationService(ReservationRepository reservationRepository, UsersService usersService) {
        this.reservationRepository = reservationRepository;
        this.usersService = usersService;
    }

    public Reservation createReservation(Reservation reservation) {
        if(!usersService.existsById(reservation.getId())){
            throw new UsersNotFoundException(reservation.getUser());
        }
        return reservationRepository.createReservation(reservation);
    }

    public List<Reservation> getByUsersId(long usersId) {
        return reservationRepository.getByUsersId(usersId);
    }


    public void confirm(ConfirmedReservDto confirmedReservDto){
        reservationRepository.confirm(confirmedReservDto);
    }

    public void cancel(ConfirmedReservDto confirmedReservDto){
        reservationRepository.cancel(confirmedReservDto);
    }


    public List<Reservation> getallReservations() {
        return reservationRepository.getallReservations();
    }

    public List<Reservation> getallFeedbacks() {
        return reservationRepository.getallFeedbacks();
    }

}
