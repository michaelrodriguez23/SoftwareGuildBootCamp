/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.service;

import com.mr.bullsandcows.dtos.GameViewModel;
import com.mr.bullsandcows.dtos.RoundViewModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface BullsAndCowsService {

    public int BeginNewGame() throws DuplicateGameException, InvalidGameException, PersistenceException;

    public RoundViewModel Guess(int gameId, String guess) throws InvalidGameException, PersistenceException, SQLException;

    public GameViewModel FindActiveGame(int gameId) throws InvalidGameException;

    public List<GameViewModel> DisplayAllGamesToDate() throws InvalidGameException; // . refer to the dao to get list of games. 

    public List<RoundViewModel> DisplayAllRounds(int gameId) throws InvalidGameException;

}
