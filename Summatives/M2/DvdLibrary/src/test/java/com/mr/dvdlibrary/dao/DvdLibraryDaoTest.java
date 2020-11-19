/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.dao;

import com.mr.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michaelrodriguez
 */
// What we need to do is instanciate the Dao 
// before each test we want to put each Dao in a good state. 
public class DvdLibraryDaoTest {

    // this gives us access to the dao 
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public DvdLibraryDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }
// The setup method for a good state can be different for each kind of testing that you are doing. 
// For example while testing when adding, and get all students. 
// We wanted to the setUp method to clear all Dvd obects. 
    
    
    @BeforeEach
    public void setUp() throws Exception {
        List<Dvd> dvdList = dao.getAllDvds();
        // we want to iterate through all the Dvds one by one, and remove them
        // this makes for blackbox testing, we dont know how the students are stored
        // but we do know if we can use the api of the dao, we can get it in a know good state.
        // this downfall of this unit testing is that if the removeDvd or getAllDvd method doesn't work
        // this test wouldnt work. Which isnt exactly bad
        // because we are testing. Its better to know than not. 
        for (Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getTitle());
        }

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddGetDvd() throws Exception {
        Dvd dvd = new Dvd("Movie 1");
        dvd.setTitle("title");
        dvd.setReleaseDate("0299");
        dvd.setDirectorsName("Wes Anderson");
        dvd.setMpaaRating("PG");
        dvd.setStudio("Disney");
        dvd.setUserCustomNote("Note");

        // We are accessing the Dao to add Dvd
        dao.addDvd(dvd.getTitle(), dvd);
        // Going to ask the Dao, to get a Dao associated 

        Dvd fromDao = dao.getDvd(dvd.getTitle());

        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        Dvd dvd1 = new Dvd("movie1");
        dvd1.setTitle("movie1");
        dvd1.setDirectorsName("director1");
        dvd1.setMpaaRating("Mpaa1");
        dvd1.setReleaseDate("releaseDate1");
        dvd1.setStudio("studio1");
        dvd1.setUserCustomNote("note1");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("movie2");
        dvd1.setTitle("movie2");
        dvd1.setDirectorsName("director2");
        dvd1.setMpaaRating("Mpaa2");
        dvd1.setReleaseDate("releaseDate2");
        dvd1.setStudio("studio2");
        dvd1.setUserCustomNote("note2");

        dao.addDvd(dvd2.getTitle(), dvd2);

        // We are expecting 2 students in the dao. 
        // We are comparing it to the size of getAllDvds
        assertEquals(2, dao.getAllDvds().size());

    }

    /**
     * Test of getDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        Dvd dvd1 = new Dvd("movie1");
        dvd1.setTitle("movie1");
        dvd1.setDirectorsName("director1");
        dvd1.setMpaaRating("Mpaa1");
        dvd1.setReleaseDate("releaseDate1");
        dvd1.setStudio("studio1");
        dvd1.setUserCustomNote("note1");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("movie2");
        dvd2.setTitle("movie2");
        dvd2.setDirectorsName("director2");
        dvd2.setMpaaRating("Mpaa2");
        dvd2.setReleaseDate("releaseDate2");
        dvd2.setStudio("studio2");
        dvd2.setUserCustomNote("note2");

        dao.addDvd(dvd2.getTitle(), dvd2);
        
        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.getAllDvds().size());
        // According to the contract from the Dao
        // If we remove a Dvd from the Dao
        // If we tried to find a removed dvd it should
        // return null
        assertNull(dao.getDvd(dvd1.getTitle()));
        
        
        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDvds().size()); 
        assertNull(dao.getDvd(dvd2.getTitle()));
        
        
    }

    /**
     * Test of editDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testEditDvd() throws Exception {
//        Dvd dvd1 = new Dvd("Movie 1");
//        dvd1.setTitle("title");
//        dvd1.setReleaseDate("0299");
//        dvd1.setDirectorsName("Wes Anderson");
//        dvd1.setMpaaRating("PG");
//        dvd1.setStudio("Disney");
//        dvd1.setUserCustomNote("Note");
//
//        // We are accessing the Dao to Edit Dvd
//        dao.editDvd(dvd1.getTitle(), dvd1);
//        dao.removeDvd(dvd1.getTitle());
//        
//        
//        
//        Dvd editedDvd = new  Dvd("Movie 1"); 
//        editedDvd.setTitle("title");
//        editedDvd.setReleaseDate("0299");
//        editedDvd.setDirectorsName("Wes Anderson");
//        editedDvd.setMpaaRating("PG");
//        editedDvd.setStudio("Disney");
//        editedDvd.setUserCustomNote("Note");
//        dao.addDvd(editedDvd.getTitle(), dvd1);
//        
//        assertEquals(1, dao.getAllDvds().size()); 
//        assertNull(dao.getDvd(dvd1.getTitle())); 
        
        
      
        
        

//       
//
//    /**
//     * Test of findByDirector method, of class DvdLibraryDao.
//     */
//    @Test
//    public void testFindByDirector() throws Exception {
//        
//    }
    }

}
