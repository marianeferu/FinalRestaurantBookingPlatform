package com.example.demo.repository;

import com.example.demo.dto.ConfirmedReservDto;
import com.example.demo.dto.NotificationDto;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

@Repository
public class NotificationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public NotificationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Notification createNotification(Notification notification) {
        String sql = "insert into notification values (null, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, notification.getMessage());
            preparedStatement.setObject(2, notification.getDate());
            preparedStatement.setObject(3, notification.getUser());


            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        notification.setId(Math.toIntExact(generatedKeyHolder.getKey().longValue()));
        return notification;
    }

    private RowMapper<Notification> getNotificationRowMapper() {
        return (resultSet, rowNum) -> {
            Notification notification = new Notification();
            notification.setId(resultSet.getInt("id"));
            notification.setMessage((String) resultSet.getObject("message"));
            notification.setDate((Date) resultSet.getObject("date"));
            notification.setUser((Users) resultSet.getObject("user"));

            return notification;
        };
    }


    public void send_notification_to_user(NotificationDto notificationDto){

        String sql = "UPDATE notification SET notification.message= ? WHERE reservation.id = ?";
        jdbcTemplate.update(sql,getNotificationRowMapper(), notificationDto); //**
    }


}
