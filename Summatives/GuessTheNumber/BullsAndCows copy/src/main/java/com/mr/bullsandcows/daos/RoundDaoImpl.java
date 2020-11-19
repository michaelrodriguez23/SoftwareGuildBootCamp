/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.dtos.RoundViewModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michaelrodriguez
 */
@Repository
@Profile("database")
public class RoundDaoImpl implements DAO<RoundViewModel> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoundDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public RoundViewModel Create(RoundViewModel roundView) {

        final String INSERT_ROUND = "INSERT INTO Round(gameId,guess,statusOfGame,timeStampOfRound,result)VALUES(?,?,?,?,?);";
        jdbcTemplate.update(INSERT_ROUND,
                roundView.getGameId(),
                roundView.getGuess(),
                roundView.getGameStatus(),
                roundView.getTimeStamp(),
                roundView.getResult());

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        roundView.setRoundViewId(newId);
        return roundView;
    }

    public List<RoundViewModel> ReadAllRounds(int gameId) {
        final String SELECT_ALL_ROUNDS = "SELECT * FROM Round WHERE gameId =?";
        return jdbcTemplate.query(SELECT_ALL_ROUNDS, new RoundMapper(), gameId);
    }

    @Override
    public RoundViewModel ReadById(int roundViewId) {
        final String SELECT_ROUND_BY_ID = "SELECT * FROM Round WHERE roundId = ?";
        RoundViewModel roundView = jdbcTemplate.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), roundViewId);
        return roundView;
    }

    public boolean Update(RoundViewModel roundView) {
        final String UPDATE_ROUND = "UPDATE Round SET guess = ?, timeStampOfRound = ?, result = ? "
                + "WHERE roundId = ?";

        return jdbcTemplate.update(UPDATE_ROUND,
                roundView.getGuess(),
                roundView.getTimeStamp(),
                roundView.getRoundViewId())>0;
    }

    @Override
    public List<RoundViewModel> ReadAll() {
        
        // not used , only reason i have it is because the interface has it. But for rounds I modified it with 
        // the method above to pass in the game Id in the view. 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
