package com.example.demo.service;
import com.example.demo.dto.ConfirmedReservDto;
import com.example.demo.dto.NotificationDto;
import com.example.demo.exceptions.UsersNotFoundException;
import com.example.demo.model.Notification;
import com.example.demo.model.Reservation;
import com.example.demo.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    private NotificationRepository notificationRepository;

    private UsersService usersService;

    public NotificationService(NotificationRepository notificationRepository, UsersService usersService) {
        this.notificationRepository = notificationRepository;
        this.usersService = usersService;
    }


    public Notification createNotification(Notification notification) {
        if(!usersService.existsById(notification.getId())){
            throw new UsersNotFoundException(notification.getUser());
        }
        return notificationRepository.createNotification(notification);
    }

    public void send_notification_to_user(NotificationDto notificationDto){
        notificationRepository.send_notification_to_user(notificationDto);
    }


}
