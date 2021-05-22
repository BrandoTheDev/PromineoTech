package com.brandothedev.create;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.brandothedev.connector.ConnectorHorse;

/**
 * 
 * @author BrandoTheDev
 *
 */
public class UpdateHorse {
    private static final Connection connection = ConnectorHorse.openConnection();

    /**
     * Update a vehicle's make via the ID parameter
     * 
     * @param make The Make of a vehicle of type string (ie "Ford")
     * @param id   The ID of the vehicle to update
     */
    public static void updateMake(String make, int id) {
	try {
	    String sql = "UPDATE VEHICLES SET make = ? where vehicle_id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1, make);

	    preparedStatement.setInt(2, id);
	    int affectedRows = preparedStatement.executeUpdate();
	    System.out.println(affectedRows + " row(s) affected !!");
	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Error cannot update the row..");
	    e.printStackTrace();

	}
    }

    /**
     * Update a vehicle's make via the ID parameter
     * 
     * @param model The Model of a vehicle of type string (ie "Mustang")
     * @param id    The ID of the vehicle to update
     */
    public static void updateModel(String model, int id) {
	try {
	    String sql = "UPDATE VEHICLES SET model = ? where vehicle_id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1, model);
	    preparedStatement.setInt(2, id);
	    int affectedRows = preparedStatement.executeUpdate();
	    System.out.println(affectedRows + " row(s) affected !!");
	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Error cannot update the row..");
	    e.printStackTrace();

	}
    }

    /**
     * Update a vehicle's make via the ID parameter
     * 
     * @param year The Year of a vehicle of type string (ie "2007")
     * @param id   The ID of the vehicle to update
     */
    public static void updateYear(String year, int id) {
	try {
	    String sql = "UPDATE VEHICLES SET year = ? where vehicle_id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1, year);
	    preparedStatement.setInt(2, id);
	    int affectedRows = preparedStatement.executeUpdate();
	    System.out.println(affectedRows + " row(s) affected !!");
	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Error cannot update the row..");
	    e.printStackTrace();

	}
    }

}
