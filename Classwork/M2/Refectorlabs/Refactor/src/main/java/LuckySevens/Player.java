/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuckySevens;

/**
 *
 * @author michaelrodriguez
 */
public class Player {

    private int startingBet;
    private int remainingBet;
    private int totalRolls;
    private int highestEarned;

    public  static void main(String[] args) {
        Player player = new Player();
        player.SetStartingBet(0);
        player.SetRemainingBet(0);
        player.setTotalRolls(0);
        player.setHighestEarned(0);
        
        player.highestEarned = 3; 
        player.totalRolls =2; 
        player.startingBet = 0;
        player.remainingBet = 0; 
        
        System.out.println(player.GetStartingBet());
        System.out.println(player.GetRemaingBet());
        System.out.println(player.GetTotalRolls());
        System.out.println(player.GetHighestEarned());
        
        

    }

    public void SetStartingBet(int startingBet) {
        this.startingBet = startingBet;

    }

    public void SetRemainingBet(int remainingBet) {
        this.remainingBet = remainingBet;
    }
    public void setTotalRolls(int totalRolls) { 
        this.totalRolls = totalRolls;
    }
    public void setHighestEarned(int highestEarned) { 
        this.highestEarned = highestEarned;
    }

    public int GetStartingBet() {
        return this.startingBet;
    }

    public int GetRemaingBet() {
        return this.remainingBet;
    }
    public int GetTotalRolls() { 
        return this.totalRolls;
    }
    public int GetHighestEarned() { 
        return this.highestEarned; 
    }

    public void printDetails() {
        System.out.println(startingBet + ", " + remainingBet);
    }
}
