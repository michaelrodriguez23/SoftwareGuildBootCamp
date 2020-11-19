/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.Dao;

import com.sg.hero.Dto.Superpower;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
public class superpowerDaoImpl implements Dao<Superpower> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Superpower Create(Superpower power) {
        final String ADD_POWER = "INSERT INTO superpower(power) VALUES (?)";
        jdbcTemplate.update(ADD_POWER, power.getPower());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        power.setSuperPowerId(newId);
        return power;
    }

    @Override
    public List<Superpower> ReadAll() {
        final String SELECT_ALL_POWERS = "SELECT * FROM superpower";
        return jdbcTemplate.query(SELECT_ALL_POWERS, new superPowerMapper());
    }

    @Override
    public Superpower ReadById(int superPowerId) {
        try {
            final String SELECT_POWER_BY_ID = "SELECT * FROM superpower WHERE superpowerId = ?";
            return jdbcTemplate.queryForObject(SELECT_POWER_BY_ID, new superPowerMapper(), superPowerId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void Update(Superpower power) {
        final String UPDATE_POWER = "UPDATE superpower SET power = ? WHERE superpowerId = ?";
        jdbcTemplate.update(UPDATE_POWER, power.getPower(), power.getSuperPowerId());
    }

    @Override
    public void Delete(int superPowerId) {
        
        Superpower power = ReadById(superPowerId);
        final String DELETE_ORGANIZATION_MEMBER_BY_SUPERPOWERID
                = "	DELETE om.*  FROM  organizationMembers om \n"
                + "    JOIN hero h ON om.heroId = h.heroId \n"
                + "    WHERE h.superpowerId = ?";

        jdbcTemplate.update(DELETE_ORGANIZATION_MEMBER_BY_SUPERPOWERID, superPowerId);

        final String DELETE_SIGHTING_BY_SUPERPOWERID = "DELETE s.*  FROM sightings s \n"
                + "    JOIN hero h ON s.heroId = h.heroId \n"
                + "    WHERE h.superpowerId = ? ";
        jdbcTemplate.update(DELETE_SIGHTING_BY_SUPERPOWERID, superPowerId);

        final String DELETE_HERO_BY_SUPERPOWERID = "DELETE  FROM hero  \n"
                + "    WHERE superpowerId = ? ";
        jdbcTemplate.update(DELETE_HERO_BY_SUPERPOWERID, superPowerId);

        final String DELETE_POWER_BY_SUPERPOWERID = "DELETE  FROM superpower  \n"
                + "WHERE superpowerId = ?";

        jdbcTemplate.update(DELETE_POWER_BY_SUPERPOWERID, superPowerId);
    }
}
//       Superpower power = ReadById(superPowerId);
//        final String DELETE_POWER = "DELETE from superpower WHERE superpowerId = ?";
//        jdbcTemplate.update(DELETE_POWER, power.getSuperPowerId());
//           final String DELETE_SUPERPOWER_BY_SIGHTING_ID ="DELETE sp.* FROM
//          superpower sp " + "JOIN hero h where sp.superpowerId = h.superpowerId
//          " + "JOIN sightings s where h.heroId = s.heroId " + "WHERE
//          s.sightingsId =?;"; jdbc.update(DELETE_SUPERPOWER_BY_SIGHTING_ID,
//          id);
//         
//         
//          final String DELETE_HERO_BY_SIGHTING_ID = "Delete h.* FROM hero h \n"
//          + "JOIN sightings s ON s.heroId = h.heroId \n" + "WHERE s.sightingsId
//          = ? ;"; jdbc.update(DELETE_HERO_BY_SIGHTING_ID, id);
//         
//          final String DELETE_LOCATION_BY_SIGHTING_ID = "DELETE l.* FROM
//          locations l " + "JOIN sightings s ON l.locationId = s.locationId " +
//          "WHERE s.sightingsId =?; ";
//         
//          jdbc.update(DELETE_LOCATION_BY_SIGHTING_ID, id); final String
//          DELETE_SIGHTING = "DELETE FROM sightings WHERE sightingId = ? ";
//          jdbc.update(DELETE_SIGHTING, DTO.getSightingId());
//         

//  * final String DELETE_SUPERPOWER_BY_SIGHTING_ID ="DELETE sp.* FROM
//         * superpower sp " + "JOIN hero h where sp.superpowerId = h.superpowerId
//         * " + "JOIN sightings s where h.heroId = s.heroId " + "WHERE
//         * s.sightingsId =?;"; jdbc.update(DELETE_SUPERPOWER_BY_SIGHTING_ID,
//         * id);
//         *
/* @Override
    @Transactional
    public void Delete(int locationId) {
        final String DELETE_sighting_BY_LOCATIONID = "DELETE FROM sightings WHERE locationId = ?";
        final String DELETE_LOCATION_BY_ID = "DELETE FROM locations WHERE locationId = ?";
        jdbc.update(DELETE_sighting_BY_LOCATIONID, locationId );
        jdbc.update(DELETE_LOCATION_BY_ID, locationId);
    }
 */
