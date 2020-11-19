/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.HashTag;
import com.mr.blogMastery.dto.Post;
import com.mr.blogMastery.dto.Role;
import com.mr.blogMastery.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michaelrodriguez
 */
@Repository
public class PostDaoImpl implements Dao<Post> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Post Create(Post DTO) {
        final String ADD_POST = "INSERT INTO Posts(userId,title,published,postDate,timePosted,timeExpiration,timeScheduled,usersPost,imgUrl,staticPageFlag)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(ADD_POST,
                DTO.getUser().getUserId(),
                DTO.getTitle(),
                DTO.isPublished(),
                DTO.getDate(),
                DTO.getTimePosted(),
                DTO.getTimeExpiration(),
                DTO.getTimeScheduled(),
                DTO.getPost(),
                DTO.getImgUrl(),
                DTO.isStaticPageFlag());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        DTO.setPostId(newId);
        insertPostHashTag(DTO);

        return DTO;
    }

    private void insertPostHashTag(Post DTO) {
        final String INSERT_POST_HASHTAG = " INSERT INTO "
                + "PostHashTags(postId,hashTagId) VALUES(?,?)";
        for (HashTag hashTag : DTO.getHashTags()) {
            jdbcTemplate.update(INSERT_POST_HASHTAG, DTO.getPostId(), hashTag.getHashTagId());
        }
    }

    @Override
    public List<Post> ReadAll() {
        final String SELECT_ALL_POSTS = "SELECT * FROM Posts ";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper());
        associateHashTagsWithPost(posts);
      //  associateUserToPost(posts);
       
        return posts;
    }
    public List<Post> ReadAllPostUnpublished() {
        final String SELECT_ALL_POSTS = "SELECT * FROM Posts "
                + "WHERE published IS FALSE ";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper());
        associateHashTagsWithPost(posts);
    
        return posts;
    }
     public List<Post> ReadAllPostPublised() {
        final String SELECT_ALL_POSTS = "SELECT * FROM Posts "
                + "WHERE published IS TRUE "
                + "ORDER BY postDate desc;";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper());
        associateHashTagsWithPost(posts);
      //  associateUserToPost(posts);
       
        return posts;
    }
     
     public List<Post> ReadAllPostStatic() {
        final String SELECT_ALL_POSTS = "SELECT * FROM Posts "
                + "WHERE staticPageFlag IS TRUE "
                + "ORDER BY postDate desc; ";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper());
        associateHashTagsWithPost(posts);

       
        return posts;
    }

      public List<Post> ReadAllPostForBlog() {
        final String SELECT_ALL_POSTS = "SELECT * FROM Posts "
                + "WHERE staticPageFlag IS FALSE AND published is True "
                + "ORDER BY postId desc; ";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper());
        associateHashTagsWithPost(posts);
       
        return posts;
    }
       public List<Post> ReadAllPostByHashTag(int hashTagId) {
        final String SELECT_ALL_POSTS = "SELECT p.* FROM Posts p "
                + "JOIN PostHashTags pht On p.postId = pht.postId "
                + "JOIN HashTags ht On pht.hashTagId = ht.hashTagId "
                + "WHERE ht.hashTagId = ? "
                + "ORDER BY postDate desc; ";
        List<Post> posts = jdbcTemplate.query(SELECT_ALL_POSTS, new PostMapper(),hashTagId);
        associateHashTagsWithPost(posts);
       
        return posts;
    }
 

    private void associateHashTagsWithPost(List<Post> posts) {
        for (Post post : posts) {
            post.setHashTags(readHashTagsByPost(post.getPostId()));
            post.setUser(getUserByPostId(post.getPostId()));

        }

    }

    public List<HashTag> readHashTagsByPost(int postId) {
        final String HASHTAGS_BY_POSTID = "SELECT h.* FROM HashTags h "
                + "JOIN PostHashTags ph ON h.hashTagId = ph.hashTagId "
                + "JOIN Posts p ON ph.postId = p.postId "
                + "WHERE p.postId = ? ";
        List<HashTag> hashTags = jdbcTemplate.query(HASHTAGS_BY_POSTID, new HashTagMapper(), postId);
        return hashTags;
    }

    @Override
    public Post ReadById(int postId) {
        try {
            final String SELECT_POST_BY_ID = "SELECT * FROM Posts WHERE postId = ?";
            Post post = jdbcTemplate.queryForObject(SELECT_POST_BY_ID, new PostMapper(), postId);
            post.setHashTags(readHashTagsByPost(post.getPostId()));
            post.setUser(getUserByPostId(post.getPostId()));
            return post;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    
    public List ReadLastPost() {
        try {
            final String SELECT_LAST_POSTS = "SELECT * FROM Posts "
                    + "WHERE staticPageFlag IS FALSE AND published is True "
                    + "ORDER BY postId DESC LIMIT 1";
           List<Post> lastPosts = jdbcTemplate.query(SELECT_LAST_POSTS, new PostMapper());
           associateHashTagsWithPost(lastPosts);
        return lastPosts;
        } catch (DataAccessException ex) {
            return null;
        }
    }
    
     public List ReadTwoRandomPost() {
        try {
            final String SELECT_RANDOM_2_POSTS = "SELECT * FROM Posts "
                    + "WHERE staticPageFlag IS FALSE AND published is True "
                    + "ORDER BY RAND() LIMIT 2 "
                     ;
           List<Post> RandomTwoPosts = jdbcTemplate.query(SELECT_RANDOM_2_POSTS, new PostMapper());
           associateHashTagsWithPost(RandomTwoPosts);
        return RandomTwoPosts;
        } catch (DataAccessException ex) {
            return null;
        }
    }
    
    
    private void associateUserToPost(List<Post> posts) {
        for (Post post : posts) {
            post.setUser(getUserByPostId(post.getPostId()));

        }
    }

    private User getUserByPostId(int postId) {
        final String USER_BY_POSTID = "SELECT u.* FROM Users u "
                + "JOIN Posts p ON u.userId = p.userId "
                + "WHERE p.postId = ? ";
        try {
            User user = jdbcTemplate.queryForObject(USER_BY_POSTID, new UserMapper(), postId); // ??
            user.setRoles(getRolesForUser(user.getUserId())); // why is this throwing an error. 
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
    public void Update(Post DTO) {
        final String UPDATE_POST = "UPDATE Posts SET userId = ?,title = ?,published = ?,postDate = ?,timePosted = ?,timeExpiration = ?,timeScheduled = ?,usersPost = ?, imgUrl = ?, staticPageFlag = ? "
                + "WHERE postId = ?";
        jdbcTemplate.update(UPDATE_POST,
                DTO.getUser().getUserId(),
                DTO.getTitle(),
                DTO.isPublished(),
                DTO.getDate(),
                DTO.getTimePosted(),
                DTO.getTimeExpiration(),
                DTO.getTimeScheduled(),
                DTO.getPost(),
                DTO.getImgUrl(),
                DTO.isStaticPageFlag(),
                DTO.getPostId());
    }

    @Override
    @Transactional
    public void Delete(int id) {
        Post DTO = ReadById(id);

        final String DELETE_POST_FROM_POSTHASHTAGS = "DELETE FROM PostHashTags WHERE postId = ?";
        jdbcTemplate.update(DELETE_POST_FROM_POSTHASHTAGS, id);

        final String UPDATE_POST = "DELETE FROM Posts "
                + "WHERE postiD = ?";
        jdbcTemplate.update(UPDATE_POST,
                DTO.getPostId());

    }

}
