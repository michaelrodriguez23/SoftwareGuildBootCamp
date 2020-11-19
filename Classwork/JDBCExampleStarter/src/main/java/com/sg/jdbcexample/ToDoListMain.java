/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbcexample;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.sql.DataSource;

/**
 *
 * @author kylerudy
 */
public class ToDoListMain {

    private static Scanner sc;
    private static DataSource ds;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        try {
            // connecting to the DataSource
            ds = getDataSource();
            // Catching any SQL Exceptions when connecting
        } catch (SQLException ex) {
            System.out.println("Error connecting to database");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
         // Controller
        do {
            System.out.println("To-Do List");
            System.out.println("1. Display List");
            System.out.println("2. Add Item");
            System.out.println("3. Update Item");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");

            System.out.println("Enter an option:");
            String option = sc.nextLine();
            try {
                switch (option) {
                    case "1":
                        displayList();
                        break;
                    case "2":
                        addItem();
                        break;
                    case "3":
                        updateItem();
                        break;
                    case "4":
                        removeItem();
                        break;
                    case "5":
                        System.out.println("Exiting");
                        System.exit(0);
                }
            } catch (SQLException ex) {
                System.out.println("Error communicating with database");
                System.out.println(ex.getMessage());
                System.exit(0);
            }

        } while (true);
    }
    
    // CRUD Method

    private static void displayList() throws SQLException {
        // Try with recources to create our connection. 
        try (Connection conn = ds.getConnection()) {
            // We create a statement with our connection, and it will never change due 
            // user input. We can get away with a statement rather than a prepared statement. 
            Statement stmt = conn.createStatement();
            // ResultSet is the data executed from the query. 
            // The query is Selecting all from the todo table 
            ResultSet rs = stmt.executeQuery("SELECT * FROM todo");
            // While there are more queries to iterate through 
            // print the id, todo , note, and finish status. 
            while (rs.next()) {
                System.out.printf("%s: %s -- %s -- %s\n",
                        rs.getString("id"),
                        rs.getString("todo"),
                        rs.getString("note"),
                        rs.getBoolean("finished"));
            }
            System.out.println("");
        }
    }

    private static void addItem() throws SQLException {
        // These are prompting the data, and storing it from the user input. 
        System.out.println("Add Item");
        System.out.println("What is the task?");
        String task = sc.nextLine();
        System.out.println("Any additional notes?");
        String note = sc.nextLine();
         // Try using connecting to our resources again. 
        try (Connection conn = ds.getConnection()) {
            // We are creating the SQL query as a String
            String sql = "INSERT INTO todo(todo, note) VALUES(?,?)"; //? 
            // Then creating a preparedStatement to prvent SQl Injection Attacks
            // Passing in the String Sql statement created above. 
            PreparedStatement pStmt = conn.prepareCall(sql);
            // The values in the arguements in the String Sql above
            // is being passed in the set String prepared Statements below.
            pStmt.setString(1, task);
            pStmt.setString(2, note);
            // executes the set Strings above. 
            pStmt.executeUpdate();
            System.out.println("Add Complete");
        }

    }

    private static void updateItem() throws SQLException {
       // Prompting + Retrieving user input for updating items. 
        System.out.println("Update Item");
        System.out.println("Which item do you want to update?");
        String itemId = sc.nextLine();
        // Connecting to the resource
        // use try - catch to connect properly dataSource. 
        try (Connection conn = ds.getConnection()) {
            String sql = "SELECT * FROM todo WHERE id = ?";
            // prepared Statements is connection.preparecall and passing
            // in the String Sql query above
            PreparedStatement pStmt = conn.prepareCall(sql);
            // creating safe prepared statement and passing in the 
            // item id .  Notice there is only one arguement needed, 
            // so only one prepared will suffice. 
            pStmt.setString(1, itemId);
            // The result set stores the executed Query 
            ResultSet rs = pStmt.executeQuery();
            // goes to the next query ? 
            rs.next();
            // Once we have a resultSet we can use it to build a toDo Obect. 
            // Instanting the todo object. 
            // Getting the fields from the resultSet . 
            ToDo td = new ToDo();
            td.setId(rs.getInt("id"));
            td.setTodo(rs.getString("todo"));
            td.setNote(rs.getString("note"));
            td.setFinished(rs.getBoolean("finished"));
            // Printing todo object fields 
            System.out.println("1. ToDo - " + td.getTodo());
            System.out.println("2. Note - " + td.getNote());
            System.out.println("3. Finished - " + td.isFinished());
            System.out.println("What would you like to change?");
            // Selecting choice from the user 
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter new ToDo:");
                    String todo = sc.nextLine();
                    td.setTodo(todo);
                    break;
                case "2":
                    System.out.println("Enter new Note:");
                    String note = sc.nextLine();
                    td.setNote(note);
                    break;
                case "3":
                    System.out.println("Toggling Finished to " + !td.isFinished());
                    td.setFinished(!td.isFinished());
                    break;
                default:
                    System.out.println("No change made");
                    return;
            }
            // String updateSql will add the updated fields
            // We use our existing connection to update the fields we would like. 
            String updateSql = "UPDATE todo SET todo = ?, note = ?, finished = ? WHERE id = ?";
            PreparedStatement updatePStmt = conn.prepareCall(updateSql);
            // Inserting the updates and setting new strings by retrieving the fields
            // via getters and setters .
            // This will update anything that has been updated, and if there wasn't anything
            // changed the update will just retrieve the member field regardless. 
            updatePStmt.setString(1, td.getTodo());
            updatePStmt.setString(2, td.getNote());
            updatePStmt.setBoolean(3, td.isFinished());
            updatePStmt.setInt(4, td.getId());
            updatePStmt.executeUpdate();
            System.out.println("Update Complete");
        }
    }

    private static void removeItem() throws SQLException {
        // prompt to select and delete item 
        System.out.println("Remove Item");
        System.out.println("Which item would you like to remove?");
        String itemId = sc.nextLine();
       // connecting to the database resource. 
        try (Connection conn = ds.getConnection()) {
            // preparing the pStatement with the String SQL query
            String sql = "DELETE FROM todo WHERE id = ?";
            PreparedStatement pStmt = conn.prepareCall(sql); 
            // The prepareStatement is setting its string to 
            // the item id that is selected by the user Above in the
            // in the scanner. 
            pStmt.setString(1, itemId);
            pStmt.executeUpdate();
            System.out.println("Remove Complete");
        }
    }
    // this is the DataSource we are refferencing in the CRUD methods . 
    // These are the setting of the DataBase that we are working with. 
    // In this case it is MySql
    private static DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("todoDB");
        ds.setUser("root");
        ds.setPassword("rootroot");
        ds.setServerTimezone("America/Chicago");
        ds.setUseSSL(false);
        ds.setAllowPublicKeyRetrieval(true);

        return ds;
    }

}
