package com.example.demo.mappers;

import com.example.demo.dto.NotificationDto;
import com.example.demo.model.Notification;

import org.springframework.stereotype.Component;


@Component
public class NotificationMapper {



    public Notification notificationDtoToNotification(NotificationDto notificationDto) {
        return new Notification(notificationDto.getMessage(), notificationDto.getDate(),notificationDto.getUser());

    }
}
