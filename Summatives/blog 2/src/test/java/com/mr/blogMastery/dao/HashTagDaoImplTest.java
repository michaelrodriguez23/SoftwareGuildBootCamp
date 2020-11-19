/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.Comment;
import com.mr.blogMastery.dto.HashTag;
import com.mr.blogMastery.dto.Post;
import com.mr.blogMastery.dto.Role;
import com.mr.blogMastery.dto.User;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author michaelrodriguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HashTagDaoImplTest {

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    PostDaoImpl postDao;

    @Autowired
    CommentDaoImpl commentDao;

    @Autowired
    RoleDaoImpl roleDao;

    @Autowired
    HashTagDaoImpl hashTagDao;

    public HashTagDaoImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Role> roles = roleDao.ReadAll();
        for (Role role : roles) {
            roleDao.Delete(role.getRoleId());
        }

        List<HashTag> hashTags = hashTagDao.ReadAll();
        for (HashTag hashTag : hashTags) {
            hashTagDao.Delete(hashTag.getHashTagId());
        }

        List<User> users = userDao.ReadAll();
        for (User user : users) {
            userDao.Delete(user.getUserId());
        }

      

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of Create method, of class HashTagDaoImpl.
     */
    @Test
    public void testCreate() {

        HashTag hashTag = new HashTag();
        hashTag.setHashTag("Test hastag");

        hashTag = hashTagDao.Create(hashTag);
        HashTag fromDao = hashTagDao.ReadById(hashTag.getHashTagId());
        assertEquals(hashTag, fromDao);

    }

    /**
     * Test of ReadAll method, of class HashTagDaoImpl.
     */
    @Test
    public void testReadAll() {

        HashTag hashTagA = new HashTag();
        hashTagA.setHashTag("Test hastag");

        hashTagA = hashTagDao.Create(hashTagA);

        HashTag hashTagB = new HashTag();
        hashTagB.setHashTag("Test hastag");

        hashTagB = hashTagDao.Create(hashTagB);

        List<HashTag> hashTags = hashTagDao.ReadAll();

        assertEquals(2, hashTags.size());
        assertTrue(hashTags.contains(hashTagA));
        assertTrue(hashTags.contains(hashTagB));

    }

    /**
     * Test of ReadById method, of class HashTagDaoImpl.
     */
    @Test
    public void testReadById() {
        // Already Tested in CreateAndGet
    }

    /**
     * Test of Update method, of class HashTagDaoImpl.
     */
    @Test
    public void testUpdate() {
        HashTag hashTag = new HashTag();
        hashTag.setHashTag("Test hastag");
        hashTag = hashTagDao.Create(hashTag);

        HashTag fromDao = hashTagDao.ReadById(hashTag.getHashTagId());
        assertEquals(hashTag, fromDao);

        hashTag.setHashTag("HashTag Update");
        hashTagDao.Update(hashTag);
        assertNotSame(hashTag, fromDao);

        fromDao = hashTagDao.ReadById(hashTag.getHashTagId());
        assertEquals(hashTag, fromDao);
    }

    /**
     * Test of Delete method, of class HashTagDaoImpl.
     */
    @Test
    public void testDelete() {
        HashTag hashTag = new HashTag();
        hashTag.setHashTag("Test hastag");
        hashTag = hashTagDao.Create(hashTag);

        HashTag fromDao = hashTagDao.ReadById(hashTag.getHashTagId());
        assertEquals(hashTag, fromDao);

        hashTagDao.Delete(hashTag.getHashTagId());
        fromDao = hashTagDao.ReadById(hashTag.getHashTagId());
        assertNull(fromDao);

    }

}
