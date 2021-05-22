package com.brandothedev.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.brandothedev.connector.ConnectorHorse;

/**
 * 
 * @author BrandoTheDev
 *
 */
public class DeleteHorse {

    private final static Connection connection = ConnectorHorse.openConnection();

    /**
     * Delete a record from the table via the row ID
     * 
     * @param id The ID of the vehicle to update
     */
    public static void delete(int id) {
	String deleteFromVehicles = "DELETE FROM VEHICLES WHERE vehicle_id = ?";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(deleteFromVehicles);
	    preparedStatement.setInt(1, id);
	    preparedStatement.execute();
	    System.out.println("Successfully deleted #" + id + " from the table.");
	    preparedStatement.close();
	} catch (Exception e) {
	    System.out.println("Something fucked up");
	    e.printStackTrace();
	}
    }
}
