/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dao;

import com.mr.blogMastery.dto.Role;
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
public class RoleDaoImpl implements Dao<Role> {

    @Autowired
    JdbcTemplate jdbc;

    /**
     *
     * @param DTO
     * @return
     */
    @Override
    public Role Create(Role DTO) {
        final String ADD_ROLE = "INSERT INTO Roles(role) "
                + "VALUES(?)";
        jdbc.update(ADD_ROLE,
                DTO.getRole());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        DTO.setRoleId(newId);
        return DTO;
       
    }

    @Override
    public List<Role> ReadAll() {
        final String SELECT_ALL_COMMENTS = "SELECT * FROM Roles";
        List<Role> roles = jdbc.query(SELECT_ALL_COMMENTS, new RoleMapper());
      

        return roles;
    }



    @Override
    public Role ReadById(int roleId) {
        try {
            final String SELECT_ROLE_BY_ID = "SELECT * FROM Roles WHERE roleId = ?";
            Role role = jdbc.queryForObject(SELECT_ROLE_BY_ID, new RoleMapper(), roleId);
            return role;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public void Update(Role DTO) {
        final String UPDATE_ROLE = "UPDATE Roles SET role = ?"
                + "WHERE roleId = ?";
        jdbc.update(UPDATE_ROLE,
                DTO.getRole(),
                DTO.getRoleId());
        final String DELETE_ROLE_FROM_USER_ROLE = "DELETE FROM UserRole WHERE roleId = ?";
        jdbc.update(DELETE_ROLE_FROM_USER_ROLE, DTO.getRoleId());
      
        
    }

   
    @Override
    public void Delete(int roleId) {
       final String DELETE_USER_ROLE = "DELETE FROM UserRole WHERE roleId = ?";
        jdbc.update(DELETE_USER_ROLE, roleId);
        
        final String DELETE_ROLE = "DELETE FROM Roles WHERE roleId = ?";
        jdbc.update(DELETE_ROLE, roleId);
    }

}
