/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.serverinventory.dao;

import com.mr.serverinventory.dto.Server;
import java.util.List;
import java.util.Map;

/**
 *
 * @author michaelrodriguez
 */
public interface ServerDao {

    public void addServer(Server server);

    public Server getServer(String name);

    public void removeServer(String name);

    public List<Server> getAllServers();

    public Map<String, List<Server>> getAllServerGroupByManufacturer();

    public List<Server> getServerByManufacturer(String manufacturer);

    public List<Server> gerServerOlderThan(int ageInYears);

    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears);

    public double getAverageServerAge();

}
