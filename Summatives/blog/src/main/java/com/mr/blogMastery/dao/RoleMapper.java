/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;
import com.mr.blogMastery.dto.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author michaelrodriguez
 */
public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
       Role role = new Role();
       
       role.setRoleId(rs.getInt("roleId"));
       role.setRole(rs.getString("role"));
       
       return role; 
    }
}
