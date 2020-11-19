/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;
import com.mr.blogMastery.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author michaelrodriguez
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        
        user.setUserId(rs.getInt("userId"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setUserName(rs.getString("userName"));
        user.setUserPassword(rs.getString("userpassword"));
        user.setEnabled(rs.getBoolean("enabled"));
        return user;
        
    }
    
}
