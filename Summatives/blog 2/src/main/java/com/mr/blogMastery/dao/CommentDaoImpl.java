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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michaelrodriguez
 */
@Repository
public class CommentDaoImpl implements Dao<Comment> {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    PostDaoImpl postDao;

    @Autowired
    UserDaoImpl userDao;

    @Override
    public Comment Create(Comment DTO) {
        final String ADD_COMMENT = "INSERT INTO Comments(userId,postId,commentDate, comment) "
                + "VALUES(?,?,?,?)";
        jdbc.update(ADD_COMMENT,
                DTO.getUser().getUserId(),
                DTO.getPost().getPostId(),
                DTO.getCommentDate(),
                DTO.getComment());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        DTO.setCommentId(newId);

        return DTO;
    }

    @Override
    public List<Comment> ReadAll() {
        final String SELECT_ALL_COMMENTS = "SELECT * FROM comments";
        List<Comment> comments = jdbc.query(SELECT_ALL_COMMENTS, new CommentMapper());
        associateUsersAndPosts(comments);
       

        return comments;
    }

    private void associateUsersAndPosts(List<Comment> comments) {
        for (Comment comment : comments) {
            comment.setUser(getUserForComment(comment.getCommentId()));
            comment.setPost(getPostForComment(comment.getCommentId()));
            

        }

    } public List<HashTag> readHashTagsByPost(int commentId) {
        final String HASHTAGS_BY_POSTID = "SELECT h.* FROM HashTags h "
                + "JOIN PostHashTags ph ON h.hashTagId = ph.hashTagId "
                + "JOIN Comments c ON ph.postId = c.postId "
                + " WHERE c.commentId = ? ";
        List<HashTag> hashTags = jdbc.query(HASHTAGS_BY_POSTID, new HashTagMapper(), commentId);
        return hashTags;
    }
    
    

  

    private User getUserForComment(int commentId) {
        final String SELECT_USER_FOR_COMMENT = "SELECT u.* FROM Users u \n"
                + "    JOIN Comments c ON u.userId = c.userId \n"
                + "    WHERE c.commentId = ?;";

        User user = jdbc.queryForObject(SELECT_USER_FOR_COMMENT, new UserMapper(), commentId);
        List<Role> roles = readRolesForUserByCommentId(commentId);
        user.setRoles(roles);

        return user;
    }
      private List<Role> readRolesForUserByCommentId(int commentId) {
        final String SELECT_ROLES_FOR_COMMENT = "SELECT * FROM Roles "
                + "JOIN UserRole ON roles.roleId = UserRole.roleId "
                + "JOIN Users ON UserRole.userId = Users.userId "
                + "JOIN Comments c ON UserRole.userId = c.UserId "
                + "WHERE c.commentId = ?";
        List<Role> roles = jdbc.query(SELECT_ROLES_FOR_COMMENT, new RoleMapper(), commentId);

        return roles;
    }

    private Post getPostForComment(int commentId) {
        final String SELECT_POST_FOR_COMMENT = "SELECT p.* "
                + "FROM Posts p \n"
                + "JOIN Comments c on p.postId = c.postId \n"
                + " WHERE c.commentId = ?;";
        Post post = jdbc.queryForObject(SELECT_POST_FOR_COMMENT, new PostMapper(), commentId);
        post.setHashTags(readHashTagsByPost(commentId)); // these r crashing
        post.setUser(getUserForPost(post.getPostId(), commentId)); // these r null
        return post; 
    }
    private User getUserForPost(int postId, int commentId){ 
          final String SELECT_USER_FOR_POST = "SELECT u.* "
                + "FROM Users u \n"
                + "JOIN Posts p ON u.userId = p.userId \n"
                + "WHERE p.postId = ?;";
           User user = jdbc.queryForObject(SELECT_USER_FOR_POST, new UserMapper(), postId);
           user.setRoles(readRolesForUserByCommentId(commentId));
           
           return user; 
    }


    @Override
    public Comment ReadById(int commentId) {
        try {
            final String SELECT_SIGHTING_BY_ID = "SELECT * FROM Comments WHERE commentId = ?";
            Comment comment = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new CommentMapper(), commentId);
            comment.setPost(getPostForComment(commentId));
            comment.setUser(getUserForComment(commentId));

            return comment;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void Update(Comment DTO) {
        final String UPDATE_COMMENT = "UPDATE comments SET commentId = ?, userId =?, postId = ?, commentDate = ?, comment = ?"
                + "WHERE commentId = ?";
        jdbc.update(UPDATE_COMMENT,
                DTO.getCommentId(),
                DTO.getUser().getUserId(),
                DTO.getPost().getPostId(),
                DTO.getCommentDate(),
                DTO.getComment(),
                DTO.getCommentId());

    }

    @Override
    public void Delete(int id) {
        final String DELETE_FROM_COMMENTS_BY_ID = "DELETE FROM comments  "
                + "WHERE commentId = ? ";
        jdbc.update(DELETE_FROM_COMMENTS_BY_ID, id);
    }

}
