package com.brandothedev.read;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.brandothedev.connector.ConnectorHorse;

/**
 * 
 * @author BrandoTheDev
 *
 */
public class ReadHorse {

    private final static Connection connection = ConnectorHorse.openConnection();

    /**
     * Reads every row from the vehicle table that satisfies the WHERE clause. The
     * OR allows us to use empty strings to skip params we dont want i.e make = ""
     * 
     * @param make  The Make of a vehicle of type string (ie "Ford")
     * @param model The Model of a vehicle of type string (ie "Mustang")
     * @param year  The Year of a vehicle of type string (ie "2007")
     * @param limit The Maximum rows you want returned of type int (ie 20 rows)
     */
    public static void read(String make, String model, String year, int limit) {
	String readFromVehiclesWhere = "SELECT * FROM VEHICLES WHERE make = ? OR model = ? OR year = ? LIMIT ?";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(readFromVehiclesWhere);
	    preparedStatement.setString(1, make);
	    preparedStatement.setString(2, model);
	    preparedStatement.setString(3, year);
	    preparedStatement.setInt(4, limit);
	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print(") ");
		System.out.print(rs.getString(4));
		System.out.print(" ");
		System.out.print(rs.getString(2));
		System.out.print(" ");
		System.out.println(rs.getString(3));
	    }

	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Something fucked up");
	    e.printStackTrace();
	}
    }

    /**
     * Reads every row from the vehicle table up to the given limit
     * 
     * @param limit The Maximum rows you want returned of type int (ie 20 rows)
     */
    public static void read(int limit) {
	String readFromVehicles = "SELECT * FROM VEHICLES LIMIT ?";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(readFromVehicles);
	    preparedStatement.setInt(1, limit);
	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print(") ");
		System.out.print(rs.getString(4));
		System.out.print(" ");
		System.out.print(rs.getString(2));
		System.out.print(" ");
		System.out.println(rs.getString(3));
	    }

	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Something fucked up");
	    e.printStackTrace();
	}
    }
}
