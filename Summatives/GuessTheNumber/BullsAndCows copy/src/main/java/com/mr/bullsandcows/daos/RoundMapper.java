/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.dtos.RoundViewModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author michaelrodriguez
 */
public class RoundMapper implements RowMapper<RoundViewModel> {

    @Override
    public RoundViewModel mapRow(ResultSet rs, int i) throws SQLException {
        RoundViewModel mappedRoundView = new RoundViewModel();
        mappedRoundView.setRoundViewId(rs.getInt("roundId"));
        mappedRoundView.setGameId(rs.getInt("gameId"));
        mappedRoundView.setGuess(rs.getString("guess"));
        mappedRoundView.setGameStatus(rs.getString("statusOfGame"));
        mappedRoundView.setTimeStamp(rs.getString("timeStampOfRound"));
        mappedRoundView.setResult(rs.getString("result"));
        return mappedRoundView;
    }

}
