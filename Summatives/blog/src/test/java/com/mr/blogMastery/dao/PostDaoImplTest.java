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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
public class PostDaoImplTest {
    // Parent -> Child Daos

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

    public PostDaoImplTest() {
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

        List<Post> posts = postDao.ReadAll();
        for (Post post : posts) {
            postDao.Delete(post.getPostId());
        }
        List<Comment> comments = commentDao.ReadAll();
        for (Comment comment : comments) {
            commentDao.Delete(comment.getCommentId());
        }

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of Create method, of class CommentDaoImpl.
     */
    @Test
    public void testCreate() {
       Role role = new Role();
        role.setRole("Test Role");
        roleDao.Create(role);
        List<Role> roles = roleDao.ReadAll();

        HashTag hashTag = new HashTag();
        hashTag.setHashTag("#HOTGIRLSUMMER");
        hashTagDao.Create(hashTag);
        List<HashTag> hashTags = hashTagDao.ReadAll();

        User user = new User();
        user.setFirstName("Test firstName");
        user.setLastName("Test Lastname");
        user.setEmail("Test Email");
        user.setUserName("Test Username");
        user.setUserPassword("Test Password");
        user.setRoles(roles);

        userDao.Create(user);

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setImgUrl("www.Test.com");
        post.setPost("Test Post");
        post.setPublished(true);
        post.setStaticPageFlag(false);
        post.setTitle("Test Title");
        post.setTimePosted(LocalDateTime.now().toLocalDate());
        post.setTimeExpiration(LocalDateTime.now().toLocalDate());
        post.setTimeScheduled(LocalDateTime.now().toLocalDate());
        post.setHashTags(hashTags);
        post.setUser(user);

        postDao.Create(post);
        Post fromDao = postDao.ReadById(post.getPostId());

        assertEquals(post, fromDao);

    }

    /**
     * Test of ReadAll method, of class CommentDaoImpl.
     */
    @Test
    public void testReadAll() {
        Role role = new Role();
        role.setRole("Test Role");
        roleDao.Create(role);
        List<Role> roles = roleDao.ReadAll();

        HashTag hashTag = new HashTag();
        hashTag.setHashTag("#HOTGIRLSUMMER");
        hashTagDao.Create(hashTag);
        List<HashTag> hashTags = hashTagDao.ReadAll();

        User user = new User();
        user.setFirstName("Test firstName");
        user.setLastName("Test Lastname");
        user.setEmail("Test Email");
        user.setUserName("Test Username");
        user.setUserPassword("Test Password");
        user.setRoles(roles);

        userDao.Create(user);

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setImgUrl("www.Test.com");
        post.setPost("Test Post");
        post.setPublished(true);
        post.setStaticPageFlag(false);
        post.setTitle("Test Title");
        post.setTimePosted(LocalDateTime.now().toLocalDate());
        post.setTimeExpiration(LocalDateTime.now().toLocalDate());
        post.setTimeScheduled(LocalDateTime.now().toLocalDate());
        post.setHashTags(hashTags);
        post.setUser(user);

        postDao.Create(post);
        List<Post> posts = postDao.ReadAll();

        assertEquals(1, posts.size());
    }

    /**
     * Test of ReadById method, of class CommentDaoImpl.
     */
    @Test
    public void testReadById() {
        // Tested In created
    }

    /**
     * Test of Update method, of class CommentDaoImpl.
     */
    @Test
    public void testUpdate() {
         Role role = new Role();
        role.setRole("Test Role");
        roleDao.Create(role);
        List<Role> roles = roleDao.ReadAll();

        HashTag hashTag = new HashTag();
        hashTag.setHashTag("#HOTGIRLSUMMER");
        hashTagDao.Create(hashTag);
        List<HashTag> hashTags = hashTagDao.ReadAll();

        User user = new User();
        user.setFirstName("Test firstName");
        user.setLastName("Test Lastname");
        user.setEmail("Test Email");
        user.setUserName("Test Username");
        user.setUserPassword("Test Password");
        user.setRoles(roles);

        userDao.Create(user);

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setImgUrl("www.Test.com");
        post.setPost("Test Post");
        post.setPublished(true);
        post.setStaticPageFlag(false);
        post.setTitle("Test Title");
        post.setTimePosted(LocalDateTime.now().toLocalDate());
        post.setTimeExpiration(LocalDateTime.now().toLocalDate());
        post.setTimeScheduled(LocalDateTime.now().toLocalDate());
        post.setHashTags(hashTags);
        post.setUser(user);

        postDao.Create(post);
        Post fromDao = postDao.ReadById(post.getPostId());

        assertEquals(post, fromDao);
        
        post.setPost("Updated Post Test");
        postDao.Update(post);
        assertNotEquals(post,fromDao);
        
        fromDao = postDao.ReadById(post.getPostId());
        
        assertEquals(post, fromDao);
        
        
    }

    /**
     * Test of Delete method, of class CommentDaoImpl.
     */
    @Test
    public void testDelete() {
        // Delete is tested in the setup
       
    }

}
