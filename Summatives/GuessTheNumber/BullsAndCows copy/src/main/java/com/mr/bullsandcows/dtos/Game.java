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
public class Game {

    private int GameId;
    private String FourDigitNumber;
    private boolean StatusOfGame;
    private String createdGameMessage; 
    
    public String getCreatedGameMessage() {
        return createdGameMessage;
    }

    public void setCreatedGameMessage(String createdGameMessage) {
        this.createdGameMessage = createdGameMessage;
    }
    
    public int getGameId() {
        return GameId;
    }

    public void setGameId(int GameId) {
        this.GameId = GameId;
    }

    public String getFourDigitNumber() {
        return FourDigitNumber;
    }

    public void setFourDigitNumber(String FourDigitNumber) {
        this.FourDigitNumber = FourDigitNumber;
    }

    public boolean getStatusOfGame() {
        return StatusOfGame;
    }

    public void setStatusOfGame(boolean Status) {
        this.StatusOfGame = Status;
    }

}
