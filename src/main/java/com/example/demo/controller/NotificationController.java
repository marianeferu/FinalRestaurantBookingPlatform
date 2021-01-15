package com.example.demo.controller;

import com.example.demo.dto.NotificationDto;
import com.example.demo.dto.ReservationDto;
import com.example.demo.mappers.NotificationMapper;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.model.Notification;
import com.example.demo.model.Reservation;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    private NotificationMapper notificationMapper;

    public NotificationController(NotificationService notificationService, NotificationMapper notificationMapper) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
    }



    @PostMapping("/addnotification")
    public ResponseEntity<Object> addNotification(@RequestBody @Valid NotificationDto notificationDto){

           Notification savedNotification =  notificationService.createNotification(notificationMapper.notificationDtoToNotification(notificationDto));
            return ResponseEntity.ok().body(savedNotification);

    }

}
