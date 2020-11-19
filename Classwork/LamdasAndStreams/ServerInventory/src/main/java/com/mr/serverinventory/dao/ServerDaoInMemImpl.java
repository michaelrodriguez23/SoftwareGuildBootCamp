/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.serverinventory.dao;

import com.mr.serverinventory.dto.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author michaelrodriguez
 */
public class ServerDaoInMemImpl implements ServerDao {
    // This is our ServerDao in memory implementation of the serverDao
    // This is where were going to put a MAP data stucture
    // This will hold all the Server Objects. 
    // The Name of the Server will be the Key, and the actual server object 
    // be the value. 
    // The Key should be unique so a name is a good candiate. 

    // This will store the servers . 
    private Map<String, Server> serverMap = new HashMap<>();

// This will put the server into itself. 
    /**
     * 1st Key Parameter will be the server getting the name and returning
     * itself. 2nd Parameter will the server itself(object).
     *
     */
    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    // This will return whatever comes back from whatever paticular name
    // is mapped to that key, or null if there isnt anything linked.
    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

// This will remove the server linked to key of the map. 
// Which will be linked to the name. 
    @Override
    public void removeServer(String name) {
        serverMap.remove(name);

    }
// We will ask our map for its values, then convert the values into an
    // Array List. 

    @Override
    public List<Server> getAllServers() {
        return new ArrayList<Server>(serverMap.values());
    }
// We want to get all the servers back, but sort them by manufacture. 
// We dont want to filter anything out, just sorting.
    
// We need to get a stream for all the values. 
// From values -> we then get the stream. 

    @Override
    public Map<String, List<Server>> getAllServerGroupByManufacturer() {
        return serverMap.values()
                .stream()
                
        // this is the terminal operation.
        // We want to group by for each Server that comes through, 
        // call the getManufacturer Method. 
                .collect(Collectors.groupingBy(Server::getManufacturer));
        
        // These are both options of syntax styling for grouping 
        // .collect(Collectors.groupingBy(s -> s.getManufacturer())); 
    }
    
    //  Very Similar to getAllServers but instead of sorting,
    //  We are filtering. 
    // Same process we will return serverMap.values()
    // Use the stream API
    // .Filter using a criteria. 
    // Whatever is true -> Will keep 
    // Whatever is fale -> Will toss
    
    
    @Override
    public List<Server> getServerByManufacturer(String manufacturer) {
    //Intermediate Operation 
 return serverMap.values()
        .stream()
        .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
    // This is the Terminal Operation to Collect the results 
        .collect(Collectors.toList()); 
    }
// Similar to the getServerByManufacturer , we will be filtering by years
    @Override
    public List<Server> gerServerOlderThan(int ageInYears) {
       return serverMap.values()
               .stream()
               .filter(s -> s.getServerAge() > ageInYears)
               .collect(Collectors.toList()); 

    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
return serverMap.values()
               .stream()
               .filter(s -> s.getServerAge() > ageInYears)
               .collect(Collectors.groupingBy(Server::getManufacturer));


    }

    @Override
    public double getAverageServerAge() {
        
        // We are asking the servermap for its values
        // Which is not a the key, but the objects.
        return serverMap.values()
                
                //We are going to grab the stream
                .stream()
                
                // We are going to  use this intermediate transformation stream of servers
                // to a stream of Longs 
            
                .mapToLong(s -> s.getServerAge())
                
                //Then we take that stream of Longs, and grab the average.
                .average() 
                
                // Then finally we are going to collect, and return it as a double 
                .getAsDouble(); 
        
    }

}
