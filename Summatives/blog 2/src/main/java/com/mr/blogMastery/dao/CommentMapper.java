/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.Comment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author michaelrodriguez
 */
public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int i) throws SQLException {
        Comment comment = new Comment();
        
        comment.setCommentId(rs.getInt("commentId"));
        comment.setCommentDate(rs.getDate("commentDate").toLocalDate());
        comment.setComment(rs.getString("comment"));

        return comment;

    }

}
