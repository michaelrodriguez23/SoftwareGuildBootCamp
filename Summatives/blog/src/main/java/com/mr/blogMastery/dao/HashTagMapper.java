/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.HashTag;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author michaelrodriguez
 */
public class HashTagMapper implements RowMapper<HashTag> {

    @Override
    public HashTag mapRow(ResultSet rs, int i) throws SQLException {
        HashTag hashTag = new HashTag();
        hashTag.setHashTagId(rs.getInt("hashTagId"));
        hashTag.setHashTag(rs.getString("hashTag"));
        
        return hashTag;
        
    }
    
}
