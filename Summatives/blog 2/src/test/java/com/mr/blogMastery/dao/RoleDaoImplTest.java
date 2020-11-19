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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
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
public class RoleDaoImplTest {

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

    public RoleDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
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

        List<Post> posts = postDao.ReadAll();
        for (Post post : posts) {
            postDao.Delete(post.getPostId());
        }
        List<Comment> comments = commentDao.ReadAll();
        for (Comment comment : comments) {
            commentDao.Delete(comment.getCommentId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Create method, of class RoleDaoImpl.
     */
    @Test
    public void testCreate() {
        Role role = new Role();
        role.setRole("role test");

        role = roleDao.Create(role);
        Role fromDao = roleDao.ReadById(role.getRoleId());
        assertEquals(role, fromDao);
    }

    /**
     * Test of ReadAll method, of class RoleDaoImpl.
     */
    @Test
    public void testReadAll() {
        Role role = new Role();
        role.setRole("role test");
        role = roleDao.Create(role);
        List<Role> roles = roleDao.ReadAll();

        assertEquals(1, roles.size());

    }

    /**
     * Test of ReadById method, of class RoleDaoImpl.
     */
    @Test
    public void testReadById() {
    }

    /**
     * Test of Update method, of class RoleDaoImpl.
     */
    @Test
    public void testUpdate() {
        Role role = new Role();
        role.setRole("role test");
        role = roleDao.Create(role);
        
        Role fromDao = roleDao.ReadById(role.getRoleId());
        assertEquals(role,fromDao);
        
        role.setRole("update test role");
        roleDao.Update(role);
        assertNotSame(role,fromDao);
        
        fromDao = roleDao.ReadById(role.getRoleId());
        assertEquals(role,fromDao);
       
    }

    /**
     * Test of Delete method, of class RoleDaoImpl.
     */
    @Test
    public void testDelete() {
          Role role = new Role();
        role.setRole("role test");
        role = roleDao.Create(role);
        
        Role fromDao = roleDao.ReadById(role.getRoleId());
        assertEquals(role,fromDao);
        
        roleDao.Delete(role.getRoleId());
        fromDao = roleDao.ReadById(role.getRoleId());
        assertNull(fromDao);
    }

}
