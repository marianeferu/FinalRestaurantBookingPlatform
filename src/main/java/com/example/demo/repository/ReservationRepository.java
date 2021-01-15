package com.example.demo.repository;

import com.example.demo.dto.ConfirmedReservDto;
import com.example.demo.dto.ReservationDto;
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
import java.util.List;

@Repository
public class ReservationRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reservation createReservation(Reservation reservation) {
        String sql = "insert into reservation values (null, ?, ?, ?,? ,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, reservation.getUser());
            preparedStatement.setObject(2, reservation.getDate());
            preparedStatement.setObject(3, reservation.getDetails_menu());
            preparedStatement.setInt(4, reservation.getNum_persons());
            preparedStatement.setObject(5, reservation.getNum_tables());
            preparedStatement.setBoolean(6, reservation.isConfirmed_reserv());
            preparedStatement.setString(7, String.valueOf(reservation.getPayment_method()));


            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        reservation.setId(Math.toIntExact(generatedKeyHolder.getKey().longValue()));
        return reservation;
    }

    public List<Reservation> getByUsersId(long user) {
        String sql = "select * from reservation where reservation.user = ?";
        return jdbcTemplate.query(sql, getReservationRowMapper(), user);
    }

    private RowMapper<Reservation> getReservationRowMapper() {
        return (resultSet, rowNum) -> {
            Reservation reservation = new Reservation();
            reservation.setId(resultSet.getInt("id"));
            reservation.setUser((Users) resultSet.getObject("user"));
            reservation.setDate((Date) resultSet.getObject("date"));
            reservation.setDetails_menu((Menu) resultSet.getObject("details_menu"));
            reservation.setNum_persons(resultSet.getInt("num_persons"));
            reservation.setNum_tables((Tables) resultSet.getObject("num_tables"));
            reservation.setConfirmed_reserv(resultSet.getBoolean("confirmed_reserv"));
            reservation.setPayment_method((Payment) resultSet.getObject("payment_method"));

            return reservation;
        };
    }

    public void confirm(ConfirmedReservDto confirmedReservDto){

        String sql = "UPDATE reservation SET reservation.confirmed_reserv=True WHERE reservation.id = ?";
        jdbcTemplate.update(sql,getReservationRowMapper(), confirmedReservDto);
    }

    public void cancel(ConfirmedReservDto confirmedReservDto){

           String sql = "DELETE from reservation WHERE reservation.Id = ?";
            jdbcTemplate.update(sql,getReservationRowMapper(), confirmedReservDto);

    }

    public List<Reservation> getallReservations() {
        String sql = "select id from reservation ";
        return jdbcTemplate.query(sql, getReservationRowMapper());
    }

    public List<Reservation> getallFeedbacks() {
        String sql = "select comment from feedback";
        return jdbcTemplate.query(sql, getReservationRowMapper());
    }

}
