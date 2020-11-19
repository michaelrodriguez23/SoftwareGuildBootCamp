/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.dtos.GameViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michaelrodriguez
 */
@Repository
@Profile("database")
public class GameDaoImpl implements DAO<GameViewModel> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GameViewModel Create(GameViewModel DTO) {

        final String sql = "INSERT INTO Games(fourDigitNumber,statusOfGame)VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {
            // jdbc template.update takes two parameters A prepeparesetatementCreator, and a keyholder
            // The creator is everything from the preparestatement to the return statement. 
            // KeyHolder is an interfaces that holds keys. 
            // We can then grab keys from the GenerateKeyHolder.  Which is a class .
            PreparedStatement statement = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, DTO.getAnswer());
            statement.setString(2, DTO.getviewModelStatus());

            return statement;

        }, keyHolder);
        // This is getting back the incremented value of the gameId . 
        // From the SQL Database. 
        DTO.setGameViewId(keyHolder.getKey().intValue());
        return DTO;
    }

    @Override
    public List<GameViewModel> ReadAll() {
        final String sql = "SELECT gameid, fourDigitNumber, statusOfGame FROM Games;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    public List<GameViewModel> ReadAllHidden() {
        final String sql = "SELECT gameid, statusOfGame FROM Games;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    public GameViewModel ReadById(int gameId) {
        final String SQL_STRING = "SELECT gameId, fourDigitNumber, statusOfGame FROM Games WHERE gameId =?;";
        return jdbcTemplate.queryForObject(SQL_STRING, new GameMapper(), gameId);
    }

    @Override
    public boolean Update(GameViewModel DTO) {

        final String sql = "UPDATE Games SET "
                + "fourDigitNumber = ?, "
                + "statusOfGame = ? "
                + "WHERE gameId = ?;";

        return jdbcTemplate.update(sql,
                DTO.getAnswer(),
                DTO.getviewModelStatus(),
                DTO.getGameViewId()) > 0;
    }

}
