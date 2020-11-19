/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.controllers;

import com.mr.bullsandcows.dtos.Game;
import com.mr.bullsandcows.dtos.GameViewModel;
import com.mr.bullsandcows.dtos.Round;
import com.mr.bullsandcows.dtos.RoundViewModel;
import com.mr.bullsandcows.service.BullsAndCowsService;
import com.mr.bullsandcows.service.DuplicateGameException;
import com.mr.bullsandcows.service.InvalidGameException;
import com.mr.bullsandcows.service.PersistenceException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author michaelrodriguez
 */
@RestController
@RequestMapping("/api/nottodo")
public class Controller {

    private Scanner sc;
    private DataSource ds;
    private BullsAndCowsService service;

    private static final List<Game> games = new ArrayList<>();
    private static final List<Round> rounds = new ArrayList<>();

    @Autowired
    public Controller(BullsAndCowsService service) {
        this.service = service;

    }

    public void run() {

    }

    @PostMapping("/begin")
    private int beginGame() throws DuplicateGameException, InvalidGameException, PersistenceException {
        int gameId = service.BeginNewGame();

        return gameId;
    }

    // The keys are the parameters to our methods 
    // the values are what we are passing through the parameters. 
    @PostMapping("/guess")
    private RoundViewModel guess(@RequestBody RoundViewModel roundView) throws InvalidGameException, PersistenceException, SQLException  {

        // I am passing in the game id and guess through the round object. 
        roundView = service.Guess(roundView.getGameId(), roundView.getGuess());

        return roundView;
    }

    @GetMapping("/game/{gameId}")
    private GameViewModel getGameById(@PathVariable int gameId) throws InvalidGameException {
        return service.FindActiveGame(gameId);
    }

    @GetMapping("/games")
    private List<GameViewModel> viewAllGames() throws InvalidGameException {
        return service.DisplayAllGamesToDate();
        
    }

    @GetMapping("/rounds/{gameId}")
    private List<RoundViewModel> viewAllRounds(@PathVariable int gameId) throws InvalidGameException {
        return service.DisplayAllRounds(gameId);
    }

}
