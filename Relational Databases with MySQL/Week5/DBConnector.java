import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBConnector {

    private LoginInfo login;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);

    public DBConnector(String userName, String userPass, String driver, String dbType, String ip, String port,
	    String database, String table) {
	this.login = new LoginInfo(userName, userPass, driver, dbType, ip, port, database, table);
    }

    public DBConnector() {
	this.login = new LoginInfo();
	setConnection();
    }

    /**
     * Moved everything into its own LoginInfo class You can set every value with
     * its constructor or call it with no params for default values
     */
    private void setConnection() {
	try {
	    System.out.println("Testing our connection to the database...");
	    this.connection = DriverManager.getConnection(login.getFullUrl(), login.getUserName(), login.getUserPass());
	    System.out.println("*** Connected successfully! *** \n\n");
	} catch (SQLException ex) {
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
    }

    /**
     * Ignoring SOLID principle and having this function check if we have a
     * connection if not then call our function to connect
     * 
     * Reads EVERYTHING from the table -- DO NOT USE ON BIG DATABASES I'd hate to
     * see the time it takes to read a bigger table.
     */
    private void readTable() {
	if (connection == null) {
	    setConnection();
	} else {
	    try {
		String query = "select * from " + login.getTable();
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery(query);

		System.out.println("List of Vehicles:");
		while (resultSet.next()) {
		    System.out.println(String.format("#%o | Make: %s | Model: %s | Year: %s |", resultSet.getInt(1),
			    resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
		}

	    } catch (SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	    }
	}
    }

    // TODO : Setup error catching

    private void updateMenu() throws SQLException {
	String make, model, year;
	int option;
	System.out.print("\n\nPlease enter the id you would like to update: #");
	int vehicleId = scanner.nextInt();

	do {
	    System.out.println();
	    System.out.println("Choose one of the following to update:\n1. Make\n2. Model\n3. Year\n4. Exit");
	    System.out.println("You are currently updating vehicle #" + vehicleId);
	    option = scanner.nextInt();
	    switch (option) {
	    case 1:
		System.out.println("Please enter a new Make:");
		make = scanner.next();
		updateValue(vehicleId, "make", make);
		break;
	    case 2:
		System.out.println("Please enter a new Model:");
		model = scanner.next();
		updateValue(vehicleId, "model", model);
		break;
	    case 3:
		System.out.println("Please enter a new Year:");
		year = scanner.next();
		updateValue(vehicleId, "year", year);
		break;
	    default:
		System.out.println("Invalid choice. Please choose 1, 2, 3, or 4");
	    }
	} while (option != 4);

    }

    /**
     * Updates a row given specific column and value to fit into a where clause This
     * is only used in our updateMenu() switch statement.
     * 
     * @param VehicleID      The ID of the vehicle we want to work with
     * @param columnToUpdate Either Make, Model or Year
     * @param updateValue    The new value to overwrite the existing value
     * @throws SQLException The usual suspect in most of my errors
     */
    private void updateValue(int VehicleID, String columnToUpdate, String updateValue) throws SQLException {
	String query = String.format("update vehicles set %s = '%s' where vehicle_id = %o", columnToUpdate, updateValue,
		VehicleID);

	statement = connection.prepareStatement(query);
	statement.executeUpdate(query);
	System.out.println("Records have been updated.");

    }

    /**
     * Attempts to delete a row given an ID Doesnt check if row exists
     * 
     * @throws SQLException
     */
    private void deleteRow() throws SQLException {
	try {
	    System.out.print("Enter the vehicle ID to delete: ");
	    int vehicleId = scanner.nextInt();
	    String query = "delete from vehicles where vehicle_id =" + vehicleId;
	    statement.executeUpdate(query);
	} catch (InputMismatchException ime) {
	    System.out.println("Invalid option. Please enter a number");
	}

    }

    /**
     * Creates a row in our table, might turn this into a switch statement Doesnt
     * handle errors or invalid entries at this time
     * 
     * @throws SQLException
     */
    private void createRow() throws SQLException {
	System.out.print("\n\nPlease enter the id you would like to create: #");
	int vehicleId = scanner.nextInt();
	String make, model, year, query;

	do {
	    System.out.print("Enter new Make: ");
	    make = scanner.next().trim();

	} while (make.length() <= 0);

	do {
	    System.out.print("Enter new Model: ");
	    model = scanner.next().trim();

	} while (model.length() <= 0);

	do {
	    System.out.print("Enter new Year: ");
	    year = scanner.next().trim();

	} while (year.length() <= 0);

	query = String.format("insert into vehicles values (%o, '%s', '%s', '%s')", vehicleId, make, model, year);
	System.out.println(query);
	statement.executeUpdate(query);

    }

    /**
     * Making sure we close everything for good practice We dont want any memory
     * leaks!!
     * 
     * @throws SQLException
     */
    private void close() throws SQLException {
	resultSet.close();
	statement.close();
	connection.close();
	scanner.close();
	System.out.println("\n *** Disconnected from Database. ***");
    }

    /**
     * My main menu loop
     */
    public void run() {
	try {
	    int option = 0;

	    do {
		System.out.println("\n");
		System.out.println(
			"*** Menu Options ***\n1. Display All The Data!\n2. Update a row\n3. Delete a row\n4. Create a row\n5. Exit the program");
		System.out.print("\n Please enter an option (1-5): ");
		option = scanner.nextInt();

		switch (option) {
		case 1:
		    readTable();
		    break;
		case 2:
		    updateMenu();
		    break;
		case 3:
		    deleteRow();
		    break;
		case 4:
		    createRow();
		    break;
		case 5:
		    close();
		    break;
		default:
		    System.out.println("Please enter a valid option 1-4");

		}
	    } while (option != 5);

	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
