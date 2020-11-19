/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import com.mr.bullsandcows.TestApplicationConfiguration;
import com.mr.bullsandcows.dtos.GameViewModel;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
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

public class GameDaoImplTest {

    @Autowired
    GameDaoImpl gameDao;

    @Autowired
    RoundDaoImpl roundDao;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // List<GameViewModel> games = gameDao.ReadAll();
        //  for(GameViewModel gameView : games) { 

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Create method, of class GameDaoImpl.
     */
    @Test
    public void testCreate() {
        GameViewModel gameView = new GameViewModel();
        gameView.setAnswer("1234");
        gameView.setviewModelStatus("In Progress");
        gameView.setGameViewId(1);
        gameView = gameDao.Create(gameView);

        GameViewModel fromDao = gameDao.ReadById(gameView.getGameViewId());

        assertEquals(gameView, fromDao);
    }

    /**
     * Test of ReadAll method, of class GameDaoImpl.
     */
    @Test
    public void testReadAll() {
        GameViewModel gameView1 = new GameViewModel();
        gameView1.setAnswer("1234");
        gameView1.setviewModelStatus("In Progress");
        gameView1.setGameViewId(1);
        gameView1 = gameDao.Create(gameView1);

        GameViewModel gameView2 = new GameViewModel();
        gameView2.setAnswer("9876");
        gameView2.setviewModelStatus("In Progress");
        gameView2 = gameDao.Create(gameView2);

        List<GameViewModel> games = gameDao.ReadAll();
        // Remember to add one more because I dont have a setup to delete the DB. 

        assertEquals(3, games.size());

    }

    /**
     * Test of ReadAllHidden method, of class GameDaoImpl.
     */
    @Test
    public void update() {
        GameViewModel gameView6 = new GameViewModel();
        gameView6.setAnswer("1234");
        gameView6.setviewModelStatus("In Progress");
        gameView6.setGameViewId(1);
        gameView6 = gameDao.Create(gameView6);

        GameViewModel fromDao = gameDao.ReadById(gameView6.getGameViewId());

        assertEquals(gameView6, fromDao);

        gameView6.setviewModelStatus("Test Status");
        gameDao.Update(gameView6);

        assertNotEquals(gameView6, fromDao);

        fromDao = gameDao.ReadById(gameView6.getGameViewId());

        assertEquals(gameView6, fromDao);

    }

    @Test
    public void testReadById() {
        //already tested in create
    }

}
