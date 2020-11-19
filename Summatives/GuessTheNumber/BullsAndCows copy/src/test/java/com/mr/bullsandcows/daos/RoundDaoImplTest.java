/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.TestApplicationConfiguration;
import com.mr.bullsandcows.dtos.GameViewModel;
import com.mr.bullsandcows.dtos.RoundViewModel;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author michaelrodriguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)

public class RoundDaoImplTest {

    @Autowired
    GameDaoImpl gameDao;

    @Autowired
    RoundDaoImpl roundDao;

    /**
     * Test of Create method, of class RoundDaoImpl.
     */
    @Test
    public void testCreate() {
        // the readAllRounds method checks if create works
        // not needed

    }

    /**
     * Test of ReadAllRounds method, of class RoundDaoImpl.
     */
    @Test
    public void testReadAllRounds() {
        GameViewModel gameView = new GameViewModel();
        gameView.setAnswer("1234");
        gameView.setviewModelStatus("In Progress");
        gameView.setGameViewId(1);

        gameView = gameDao.Create(gameView);

        GameViewModel gameView2 = new GameViewModel();
        gameView2.setAnswer("9876");
        gameView2.setviewModelStatus("In Progress");
        gameView.setGameViewId(2);
        gameView2 = gameDao.Create(gameView2);

        RoundViewModel roundView1 = new RoundViewModel();

        roundView1.setGameStatus("In Progress");
        roundView1.setTimeStamp("Test timestamp");
        roundView1.setResult("T result");
        roundView1.setRoundViewId(1);
        roundView1.setGuess("1234");
        roundView1.setGameId(2);
        roundView1 = roundDao.Create(roundView1);

        RoundViewModel roundView2 = new RoundViewModel();
        roundView2.setGameId(2);

        roundView2.setGameStatus("In Progress");
        roundView2.setTimeStamp("Test timestamp");
        roundView2.setResult("T result");
        roundView2.setRoundViewId(1);
        roundView2.setGuess("1234");
        roundView2.setGameId(2);
        roundView2 = roundDao.Create(roundView2);

        List<RoundViewModel> rounds = roundDao.ReadAllRounds(roundView2.getGameId()); // Remember to add one more because I dont have a setup to delete the DB. 

        assertEquals(2, rounds.size());

    }

    /**
     * Test of ReadById method, of class RoundDaoImpl.
     */
    @Test
    public void testReadById() {
        RoundViewModel roundView5 = new RoundViewModel();
        roundView5.setGameId(1);

        roundView5.setGameStatus("In Progress");
        roundView5.setTimeStamp("Test timestamp");
        roundView5.setResult("T result");
        roundView5.setRoundViewId(3);
        roundView5.setGuess("1239");
        roundView5 = roundDao.Create(roundView5);

        RoundViewModel fromDao = roundDao.ReadById(roundView5.getRoundViewId()); // Remember to add one more because I dont have a setup to delete the DB. 

        assertEquals(roundView5.getRoundViewId(), fromDao.getRoundViewId());

    }
}
