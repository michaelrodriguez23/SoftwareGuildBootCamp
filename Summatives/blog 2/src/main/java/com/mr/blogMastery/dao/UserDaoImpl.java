/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.Post;
import com.mr.blogMastery.dto.Role;
import com.mr.blogMastery.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michaelrodriguez
 */
@Repository
public class UserDaoImpl implements Dao<User> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User Create(User DTO) {
        final String ADD_USER = "INSERT INTO Users(firstName, lastName, email, userName, userPassword, enabled)"
                + "VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(ADD_USER,
                DTO.getFirstName(),
                DTO.getLastName(),
                DTO.getEmail(),
                DTO.getUserName(),
                DTO.getUserPassword(),
                DTO.isEnabled());

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        DTO.setUserId(newId);
        insertUserRole(DTO);

        return DTO;
    }

    private void insertUserRole(User DTO) {
        final String INSERT_USER_ROLE = " INSERT INTO "
                + "UserRole(userId,roleId) VALUES(?,?)";
        for (Role role : DTO.getRoles()) {
            jdbcTemplate.update(INSERT_USER_ROLE, DTO.getUserId(), role.getRoleId());
        }

    }

    @Override
    public List<User> ReadAll() {
        final String SELECT_ALL_USERS = "SELECT * FROM Users";
        List<User> users = jdbcTemplate.query(SELECT_ALL_USERS, new UserMapper());
        associateRolesAndUsers(users);

        return users;
    }

    public void associateRolesAndUsers(List<User> users) {
        for (User user : users) {
            user.setRoles(readRolesByUser(user.getUserId()));

        }
    }

    public List<Role> readRolesByUser(int userId) {
        final String POST_BY_USERID = "SELECT r.* FROM Roles r "
                + "JOIN UserRole ur ON r.roleId = Ur.roleId "
                + "JOIN Users u ON ur.userId = u.userId "
                + "WHERE u.userId = ? ";
        return this.jdbcTemplate.query(POST_BY_USERID, new RoleMapper(), userId);
    }

    @Override
    public User ReadById(int userId) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM Users WHERE userId = ?";
            User user = jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new UserMapper(), userId);
            user.setRoles(getRolesForUser(user.getUserId()));

            return user;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    private List<Role> getRolesForUser(int userId) {
        final String SELECT_ROLES_FOR_USER = "SELECT r.* FROM Roles r "
                + "JOIN UserRole ur ON r.roleId = ur.roleId "
                + "WHERE ur.userId = ?";
        List<Role> roles = jdbcTemplate.query(SELECT_ROLES_FOR_USER, new RoleMapper(), userId);

        return roles;

    }

    @Override
    public void Update(User DTO) {
        final String UPDATE_USER = "UPDATE Users SET firstName = ?, lastName = ?, email = ?, userName = ?, userPassword = ?, enabled = ? "
                + "WHERE userId = ?";
        jdbcTemplate.update(UPDATE_USER,
                DTO.getFirstName(),
                DTO.getLastName(),
                DTO.getEmail(),
                DTO.getUserName(),
                DTO.getUserPassword(),
                DTO.isEnabled(),
                DTO.getUserId());

    }

    @Override
    public void Delete(int userId) {
        User user = ReadById(userId);

        final String SELECT_POST_BY_USERID = "SELECT * FROM Posts WHERE userId = ?";
        List<Post> postList = jdbcTemplate.query(SELECT_POST_BY_USERID, new PostMapper(), userId);

        for (Post post : postList) {
            final String DELETE_POST_HASHTAGS = "DELETE FROM PostHashTags WHERE postId = ?";
            jdbcTemplate.update(DELETE_POST_HASHTAGS, post.getPostId());

            final String DELETE_COMMENT = "DELETE FROM Comments WHERE postId = ?";
            jdbcTemplate.update(DELETE_COMMENT, post.getPostId());

            final String DELETE_POST = "DELETE FROM Posts WHERE postId = ?";
            jdbcTemplate.update(DELETE_POST, post.getPostId());

        }
        final String DELETE_COMMENT = "DELETE FROM Comments WHERE userId = ?";
        jdbcTemplate.update(DELETE_COMMENT, userId);

        final String DELETE_USER_ROLE = "DELETE FROM UserRole WHERE userId = ?";
        jdbcTemplate.update(DELETE_USER_ROLE, userId);

        final String DELETE_USER = "DELETE FROM Users WHERE userId = ?";
        jdbcTemplate.update(DELETE_USER, userId);

    }
    public User getUserByUsername(String username) {
        try {
            final String SELECT_USER_BY_USERNAME = "SELECT * FROM Users WHERE userName = ?";
            User user = jdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), username);
            user.setRoles(getRolesForUser(user.getUserId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }
}
