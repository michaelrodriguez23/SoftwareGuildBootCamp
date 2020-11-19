/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.HashTag;
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
public class HashTagDaoImpl implements Dao<HashTag> {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public HashTag Create(HashTag DTO) {
        final String ADD_HASHTAG = "INSERT INTO HashTags(hashTag) "
                + "VALUES(?)";
        jdbc.update(ADD_HASHTAG,
                DTO.getHashTag());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        DTO.setHashTagId(newId);
        return DTO;
    }

    @Override
    public List<HashTag> ReadAll() {
        final String SELECT_ALL_HASHTAGS = "SELECT * FROM HashTags";
        return jdbc.query(SELECT_ALL_HASHTAGS, new HashTagMapper());
    }

    public List<HashTag> ReadAllHashTagsByPostId(int postId) {
        final String SELECT_ALL_HASHTAGS_BY_Post_Id = "SELECT ht.* FROM HashTags ht "
                + "JOIN PostHashTags pht ON ht.hashTagId = pht.hashTagId "
                + "Where postId = ?";
        
        return jdbc.query(SELECT_ALL_HASHTAGS_BY_Post_Id, new HashTagMapper(),postId);
    }
    
   
    

    @Override
    public HashTag ReadById(int hashTagId) {
        try {
            final String SELECT_HASHTAG_BY_ID = "SELECT * FROM HashTags WHERE hashTagId = ?";
            return jdbc.queryForObject(SELECT_HASHTAG_BY_ID, new HashTagMapper(), hashTagId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void Update(HashTag DTO) {
        final String UPDATE_LOCATION = "UPDATE HashTags SET hashTag = ? "
                + "WHERE hashTagId = ?";
        jdbc.update(UPDATE_LOCATION,
                DTO.getHashTag(),
                DTO.getHashTagId());
    }

    @Override
    @Transactional
    public void Delete(int commentId) {
        
        final String DELETE_POST_HASHTAG_BY_ID = "DELETE FROM PostHashTags WHERE hashTagId = ?";

        jdbc.update(DELETE_POST_HASHTAG_BY_ID, commentId);

        final String DELETE_HASHTAG_BY_ID = "DELETE FROM HashTags WHERE hashTagId = ?";

        jdbc.update(DELETE_HASHTAG_BY_ID, commentId);
    }

    public List ReadAllByHashTagId(Integer id) {
  final String SELECT_ALL_HASHTAGS_BY_Post_Id = "SELECT * FROM HashTags  "
                + "WHERE hashTagId = ?";
        
        return jdbc.query(SELECT_ALL_HASHTAGS_BY_Post_Id, new HashTagMapper(),id);
    
    }

}
