package com.example.demo.service;

import com.example.demo.exceptions.UsersNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.ReservationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private UsersService usersService;
    @InjectMocks
    private ReservationService reservationService;


    @Test
    @DisplayName("Create reservation - it works")
    void createReservation() {

        Reservation reservation = new Reservation("Florin", true);
        Reservation savedReservation = new Reservation(1, "Florin", true);
        when(usersService.existsById(reservation.getId())).thenReturn(true);
        when(reservationRepository.createReservation(any())).thenReturn(savedReservation);

        Reservation result = reservationService.createReservation(reservation);

        assertEquals(reservation.getUser(), result.getUser());
        assertEquals(reservation.isConfirmed_reserv(), result.isConfirmed_reserv());
        assertEquals(reservation.getId(), result.getId());
        assertEquals(0, result.getId());
        verify(reservationRepository).createReservation(any());

    }

























    /*@Test
    @DisplayName("Create reservation - user doesn't exist")
    void createTripThrowsException() {
        Reservation reservation = new Reservation(3,"Florin", true);
     //   Reservation savedReservation = new Reservation(1, "Florin", true);
        when(usersService.existsById(reservation.getId())).thenReturn(false);

        UsersNotFoundException exception = assertThrows(UsersNotFoundException.class,
                () -> reservationService.createReservation(reservation));

        assertEquals("The user with id 3 doesn't exist.", exception.getMessage());

        verify(usersService).existsById(reservation.getId());
        verify(reservationRepository).createReservation(any());
    }*/


}