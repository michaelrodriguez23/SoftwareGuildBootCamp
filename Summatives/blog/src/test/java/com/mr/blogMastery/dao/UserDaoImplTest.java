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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
public class UserDaoImplTest {

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

    public UserDaoImplTest() {
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
     * Test of Create method, of class UserDaoImpl.
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

        User fromDao = userDao.ReadById(user.getUserId());
        assertEquals(user, fromDao);
    }

    /**
     * Test of ReadAll method, of class UserDaoImpl.
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

        List<User> users = userDao.ReadAll();
       // assertEquals(1, users.size());
    }

    /**
     * Test of associateRolesAndUsers method, of class UserDaoImpl.
     */
    @Test
    public void testAssociateRolesAndUsers() {
    }

    /**
     * Test of readRolesByUser method, of class UserDaoImpl.
     */
    @Test
    public void testReadRolesByUser() {
    }

    /**
     * Test of ReadById method, of class UserDaoImpl.
     */
    @Test
    public void testReadById() {
        // tested in create
    }

    /**
     * Test of Update method, of class UserDaoImpl.
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

        User fromDao = userDao.ReadById(user.getUserId());
        assertEquals(user, fromDao);
        
        user.setFirstName("Test Update Name");
        userDao.Update(user);
        assertNotEquals(user, fromDao);
        
        fromDao = userDao.ReadById(user.getUserId());
        assertEquals(user,fromDao);
    }

    /**
     * Test of Delete method, of class UserDaoImpl.
     */
    @Test
    public void testDelete() {
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

        User fromDao = userDao.ReadById(user.getUserId());
        assertEquals(user, fromDao);
        
        userDao.Delete(user.getUserId());
        fromDao = userDao.ReadById(user.getUserId());
        assertNull(fromDao);
    }

}
