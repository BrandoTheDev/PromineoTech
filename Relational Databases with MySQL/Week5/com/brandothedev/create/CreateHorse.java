package com.brandothedev.create;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.brandothedev.connector.ConnectorHorse;

/**
 * 
 * @author BrandoTheDev
 *
 */
public class CreateHorse {

    private final static Connection connection = ConnectorHorse.openConnection();

    /**
     * Creates a new row into the vehicle table
     * 
     * @param make  The Make of a vehicle of type string (ie "Ford")
     * @param model The Model of a vehicle of type string (ie "Mustang")
     * @param year  The Year of a vehicle of type string (ie "2007")
     */
    public static void create(String make, String model, String year) {
	String insertIntoVehicles = "INSERT INTO VEHICLES (make, model, year) VALUES(?,?,?)";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(insertIntoVehicles);
	    preparedStatement.setString(1, make);
	    preparedStatement.setString(2, model);
	    preparedStatement.setString(3, year);
	    int affectedRows = preparedStatement.executeUpdate();
	    System.out.println(affectedRows + " row(s) affected !!");
	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Error trying to create new row.");
	    e.printStackTrace();

	}
    }

}
