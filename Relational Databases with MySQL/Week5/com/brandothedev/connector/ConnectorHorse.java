package com.brandothedev.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * All the info the connect to the database I decided to just hard code these
 * 
 * @author BrandoTheDev
 *
 */
public class ConnectorHorse {
    public static String userName = "root";
    public static String userPass = "root";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/promineotech";
    private static Connection connection = null;

    public ConnectorHorse() {
	System.out.println("Connector horse is running!"); // I thought I was funny
    }

    /**
     * Tests for a connection to our database
     * 
     * @return connection
     */
    public static Connection openConnection() {
	try {
	    connection = DriverManager.getConnection(connectionUrl, userName, userPass);
	    System.out.println("*** Connected to database! ***");
	} catch (SQLException e) {
	    System.out.println("*** Connection Error! ***");
	    e.printStackTrace();
	}
	return connection;
    }

    /**
     * Close our connection when we finish
     */
    public static void closeConnection() {
	try {
	    if (!connection.isClosed()) {
		connection.close();
		System.out.println("Connection successfully closed.");
	    }
	} catch (SQLException e) {
	    System.out.println("Connection is already closed.");
	    e.printStackTrace();
	}
    }

}
