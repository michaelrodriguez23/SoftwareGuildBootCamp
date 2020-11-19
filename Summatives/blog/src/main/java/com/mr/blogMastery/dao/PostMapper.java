/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author michaelrodriguez
 */
public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int i) throws SQLException {
        Post post = new Post();

        post.setPostId(rs.getInt("postId"));
        post.setTitle(rs.getString("title"));
        post.setPublished(rs.getBoolean("published"));
        post.setDate(rs.getDate("postDate").toLocalDate());
        post.setTimePosted(rs.getDate("timePosted").toLocalDate());
        post.setTimeExpiration(rs.getDate("timeExpiration").toLocalDate());
        post.setTimeScheduled(rs.getDate("timeScheduled").toLocalDate());
        post.setPost(rs.getString("usersPost"));
        post.setImgUrl(rs.getString("imgUrl"));
        post.setStaticPageFlag(rs.getBoolean("staticPageFlag"));
       
        
      
        
        return post;
    }

}
