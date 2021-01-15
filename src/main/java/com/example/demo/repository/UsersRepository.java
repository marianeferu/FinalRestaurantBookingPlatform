package com.example.demo.repository;

import com.example.demo.dto.RegisterDto;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public Users register(Users users) {

        String sql = "insert into users values (null, ?, ?)";

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getDescription());
/*            preparedStatement.setString(4, String.valueOf(users.getReservation_user()));
            preparedStatement.setString(5, String.valueOf(users.getHistory_reservation()));
            preparedStatement.setString(6, users.get);*/

            return preparedStatement;

        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        users.setId((int) generatedKeyHolder.getKey().longValue());
        return users;
    }

    public Optional<Users> getByUsername(String username) {
        String sql = "select * from users where users.Username = ?";

        List<Users> result = jdbcTemplate.query(sql, getUsersRowMapper(), username);
        if(result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }


    private RowMapper<Users> getUsersRowMapper() {
        return (resultSet, rowNum) -> {
            Users users = new Users();
            users.setId(resultSet.getInt("Id"));
            users.setUsername(resultSet.getString("Username"));
            users.setPassword(resultSet.getString("Password"));
            users.setUser_role(resultSet.getBoolean("User_Role"));

            return users;
        };
    }

    public boolean existsById(long id) {
        String sql = "select * from users where users.id = ?";
        List<Users> result = jdbcTemplate.query(sql, getUsersRowMapper(), id);
        if(result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public Users login(Users users) {

        String sql = "insert into users values (null, ?, ?)";

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());


            return preparedStatement;

        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        users.setId((int) generatedKeyHolder.getKey().longValue());
        return users;
    }



}
