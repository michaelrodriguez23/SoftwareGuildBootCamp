/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.dtos;

/**
 *
 * @author michaelrodriguez
 */
public class RoundViewModel {

    private int roundViewId;
    private String guess;
    private String result;
    private int gameId;
    private String gameStatus;
    private String timeStamp;


    public int getRoundViewId() {
        return roundViewId;
    }

    public void setRoundViewId(int roundViewId) {
        this.roundViewId = roundViewId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
