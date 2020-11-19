/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import com.mr.serverinventory.dao.ServerDao;
import com.mr.serverinventory.dao.ServerDaoInMemImpl;
import com.mr.serverinventory.dto.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) {
        ServerDao dao = new ServerDaoInMemImpl();

        // Create several Servers to manipulate
        // Test Data to play around with 0_o
        Server myServer = new Server();
        myServer.setName("web01");
        myServer.setIp("192.168.1.1");
        myServer.setManufacturer("Dell");
        myServer.setRam(8);
        myServer.setNumProcessors(9);
        myServer.setPurchaseiDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("db01");
        myServer.setIp("192.168.3.45");
        myServer.setManufacturer("HP");
        myServer.setRam(16);
        myServer.setNumProcessors(24);
        myServer.setPurchaseiDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        myServer = new Server();
        myServer.setName("hr124");
        myServer.setIp("192.168.32.111");
        myServer.setManufacturer("IBM");
        myServer.setRam(16);
        myServer.setNumProcessors(12);
        myServer.setPurchaseiDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        List<Server> dells = dao.getServerByManufacturer("Dell");
        for (Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }
        dells.stream()
                .forEach(s -> System.out.println(s.getName()));

        // Lambdas and Streams Possibilities 
        // We are going to take all the servers outta of the DAO
        // and group them by manufacturer into list of Servers. 
        Map<String, List<Server>> serverMap = dao.getAllServerGroupByManufacturer();

        // We got then got the Set of all the keys in the Map above. 
        Set<String> manufacturers = serverMap.keySet();

        // We twanted to iterate through them all.
        // for the keySet, we used Stream
        // We passed in the Name to iterate one by one
        // then printed a seperator ==== 
        // and printed the manufacturer 
        // We then grabbed the List of servers associated with the manufacturer name
        // we grabbed the stream, and for each server in that list, we printed the name 
        manufacturers.stream()
                .forEach(name -> {
                    System.out.println("================================");
                    System.out.println("manufacturer: " + name);
                    serverMap.get(name).stream().forEach(s -> System.out.println(s.getName()));

                });

    }

}
