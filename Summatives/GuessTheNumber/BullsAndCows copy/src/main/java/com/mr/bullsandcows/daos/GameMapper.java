/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.dtos.GameViewModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author michaelrodriguez
 */
public class GameMapper implements RowMapper<GameViewModel> {

    @Override
    public GameViewModel mapRow(ResultSet rs, int i) throws SQLException {
        GameViewModel mappedGame = new GameViewModel();
        mappedGame.setGameViewId(rs.getInt("gameId"));
        mappedGame.setAnswer(rs.getString("fourDigitNumber"));
        mappedGame.setviewModelStatus(rs.getString("statusOfGame"));
        return mappedGame;
    }

}
