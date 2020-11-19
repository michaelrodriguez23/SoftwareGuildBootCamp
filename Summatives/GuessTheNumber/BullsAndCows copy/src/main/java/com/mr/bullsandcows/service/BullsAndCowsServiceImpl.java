/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.service;

import com.mr.bullsandcows.daos.GameDaoImpl;
import com.mr.bullsandcows.daos.RoundDaoImpl;
import com.mr.bullsandcows.dtos.GameViewModel;
import com.mr.bullsandcows.dtos.RoundViewModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

/**
 *
 * @author michaelrodriguez
 */
@Service
public class BullsAndCowsServiceImpl implements BullsAndCowsService {

    StringBuilder sb = new StringBuilder();
    public static String randomNumber;
    private static final AtomicInteger count = new AtomicInteger(0);

    private GameDaoImpl gameDao;
    private RoundDaoImpl roundDao;

    public BullsAndCowsServiceImpl(GameDaoImpl gameDao, RoundDaoImpl roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;

    }

    @Override

    public int BeginNewGame() throws DuplicateGameException, InvalidGameException, PersistenceException {

        GameViewModel gameViewModel = new GameViewModel();
        // what my randomNumber generator is returning is a string, and I am assigning it to answer
        // To then be passed in through the Game DTO. 

        // Game Id Auto-Incrementation 
        int newGameId;
        newGameId = count.incrementAndGet();

        // Random Number Generator to String. 
        // Looping through hashet to find duplicates, if none are apparent then add the new number. 
        HashSet hs = new HashSet();
        while (hs.size() < 4) {
            int random;

            random = (int) (Math.random() * 8 + 1);
            String a = String.valueOf(random);
            if (!hs.contains(a)) {
                hs.add(a);

            }
            // removing all special characters -> "\\W" is shorthand 
        }
        String answerToString = hs.toString().replaceAll("\\W", "");
        for (int i = 0; i < 4; i++) {

        }
        gameViewModel.setviewModelStatus("In Progress");

        gameViewModel.setAnswer(answerToString);
        gameViewModel.setGameViewId(newGameId);
        gameDao.Create(gameViewModel);

        return newGameId;
    }

    @Override

    public RoundViewModel Guess(int gameId, String guess) throws InvalidGameException, PersistenceException {
        LocalDateTime ldt = LocalDateTime.now();
        String ldtParsed = ldt.toString();

        GameViewModel gameView = gameDao.ReadById(gameId);

        RoundViewModel roundView = new RoundViewModel();

        roundView.setGameId(gameId);

        String usersGuess = guess;

        String answer = gameView.getAnswer();
        int stringLength = 4;
        int exactCounter = 0;
        int partialCounter = 0;
        // Creating char arrays to compare characters. 
        char[] charGuess = usersGuess.toCharArray();
        char[] charAnswer = answer.toCharArray();

        if (usersGuess.length() == 4) {
            roundView.setGuess(usersGuess);

            for (int i = 0; i < stringLength; i++) {

                if (charGuess[i] == charAnswer[i]) {
                    exactCounter++;
                }
                if (guess.contains(answer.substring(i, i + 1))) {
                    partialCounter++;
                }

            }

        }

        if (exactCounter == 4) {
            gameView.setGameViewId(gameId);
            roundView.setGameStatus("Completed");
            gameView.setviewModelStatus("Completed");
            gameView.setAnswer(answer);
            gameDao.Update(gameView);
        } else {
            roundView.setGameStatus("In Progress");
            gameView.setviewModelStatus("In Progress");
        }
        String gameStatus = ("e:" + exactCounter + ":p:" + partialCounter);
        roundView.setResult(gameStatus);
        gameView.setviewModelStatus(gameStatus);

        //round.setTimeStamp(ldt.toString());
        roundView.setTimeStamp(ldtParsed);
        // I am creating and setting a roundView object to be sent to the DAO
        // The Dao is persisting then returning that object back here tot the service
        // then to be sent back to the controller. 
        RoundViewModel newRound = roundDao.Create(roundView);
        
        return newRound;

    }

    @Override
    public GameViewModel FindActiveGame(int gameId) throws InvalidGameException {
        ArrayList<RoundViewModel> roundList = (ArrayList<RoundViewModel>) roundDao.ReadAllRounds(gameId);

        RoundViewModel lastRound = roundList.get(roundList.size() - 1);

        String roundStatus = lastRound.getGameStatus();
        GameViewModel gameView = gameDao.ReadById(gameId);

        gameView.setGameViewId(gameId);
        gameView.setAnswer(gameView.getAnswer());

        // if last roundStatus = completed -> get the answer. 
        // else -> Hide the answer. 
        if (roundStatus.trim().equals("Completed")) {
       
            gameView.setviewModelStatus(roundStatus);
             gameDao.Update(gameView);

        } else {
            gameView.setAnswer("Hidden");
            

        }
       
        return gameView;

    }

    @Override
    public List<GameViewModel> DisplayAllGamesToDate() throws InvalidGameException {

        List<GameViewModel> games = gameDao.ReadAll();

        for (int i = 0; i < games.size(); ++i) {
            GameViewModel currentGame = games.get(i);

            if (currentGame.getviewModelStatus().trim().equals("Completed")) {
                currentGame.setAnswer(currentGame.getAnswer());
                currentGame.setviewModelStatus("Completed");

            } else {
                currentGame.setAnswer("Hidden");
                currentGame.setviewModelStatus("In Progress");

            }

        }
        return games;

    }

    @Override
    public List<RoundViewModel> DisplayAllRounds(int gameId) throws InvalidGameException {

        return roundDao.ReadAllRounds(gameId);

    }

}
