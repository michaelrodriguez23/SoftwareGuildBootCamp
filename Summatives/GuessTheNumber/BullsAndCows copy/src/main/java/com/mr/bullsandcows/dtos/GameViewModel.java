/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.dtos;

import java.util.Objects;

/**
 *
 * @author michaelrodriguez
 */
public class GameViewModel{
    
    private int gameViewId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.gameViewId;
        hash = 59 * hash + Objects.hashCode(this.answer);
        hash = 59 * hash + Objects.hashCode(this.viewModelStatus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameViewModel other = (GameViewModel) obj;
        if (this.gameViewId != other.gameViewId) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.viewModelStatus, other.viewModelStatus)) {
            return false;
        }
        return true;
    }
    private String answer;
    private String viewModelStatus;


    public int getGameViewId() {
        return gameViewId;
    }

    public void setGameViewId(int gameViewId) {
        this.gameViewId = gameViewId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getviewModelStatus() {
        return viewModelStatus;
    }

    public void setviewModelStatus(String viewModelStatus) {
        this.viewModelStatus = viewModelStatus;
    }

}
