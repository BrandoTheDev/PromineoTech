import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBConnector {
    /**
     * Could use a scanner for console or listeners for GUIs Then save/read to a
     * file for persistence, encrypting their password & hiding it from screen using
     * the Console library but for simplicity sake I'm using hard coded values
     */
    private String userName = "promineoadmin";
    private String userPass = "promineoadmin";
    private String driver = "jdbc";
    private String dbType = "mysql";
    private String ip = "localhost";
    private String port = "3306";
    private String database = "promineotech";
    private String fullUrl = String.format("%s:%s://%s:%s/%s", driver, dbType, ip, port, database);

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Setting the class variable connector at creation to be used through out the
     * class Reading out the table rows one time (This would be a terrible idea on a
     * real database that has hundreds of thousands of rows.) But for the sake of
     * time im calling it to also set the class statement variable
     */
    public DBConnector() {
	setConn();
	readTable();
    }

    /**
     * Attempts to make a connection to a database Sets the conn variable and prints
     * successful or prints out errors if failed
     */
    private void setConn() {
	try {
	    System.out.println("Testing connection to database...");
	    Connection conn = DriverManager.getConnection(fullUrl, userName, userPass);
	    System.out.println("*** Connected successfully! *** \n\n");
	    this.conn = conn;
	} catch (SQLException ex) {
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
    }

    /**
     * Reads in the entire vehicle table. The worst example as its not dynamic,
     * terrible for larger sets, uses statements instead of prepared statements
     * 
     * If we lose connection it will call setConn again
     */
    private void readTable() {
	if (conn == null) {
	    setConn();
	} else {
	    try {
		String query = "select * from vehicles";
		stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery(query);

		System.out.println("List of Vehicles:");
		while (rs.next()) {
		    System.out.println(String.format("#%o | Make: %s | Model: %s | Year: %s |", rs.getInt(1),
			    rs.getString(2), rs.getString(3), rs.getString(4)));
		}

	    } catch (SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	    }
	}
    }

    /**
     * Updates a row based on the given Id, arguments can be empty strings to
     * represent that field not changing
     */
    private void updateValue() throws SQLException {
	System.out.print("\n\nPlease enter the id you would like to update: #");
	int vehicleId = scanner.nextInt();

	System.out.print("Enter new Make: ");
	String make = scanner.nextLine().trim();
	System.out.print("Enter new Model: ");
	String model = scanner.nextLine().trim();
	System.out.print("Enter new Year: ");
	String year = scanner.nextLine().trim();

	StringBuilder updateStr = new StringBuilder();
	if (!make.isEmpty()) {
	    updateStr.append(String.format(" make = '%s'", make));
	}
	if (!model.isEmpty()) {
	    updateStr.append(String.format(" model = '%s'", model));
	}
	if (!year.isEmpty()) {
	    updateStr.append(String.format(" year = '%s'", year));
	}
	String query = String.format("update vehicles set %s where vehicle_id = %o", updateStr.toString(), vehicleId);
	stmt.executeUpdate(query);
    }

    /**
     * Attempts to delete a given row
     * <p>
     * Because we are using auto_increment with InnoDB the id will not be reused
     */
    private void deleteRow() throws SQLException {
	try {
	    System.out.print("Enter the vehicle ID to delete: ");
	    int vehicleId = scanner.nextInt();
	    String query = "delete from vehicles where vehicle_id =" + vehicleId;
	    stmt.executeUpdate(query);
	} catch (InputMismatchException ime) {
	    System.out.println("Invalid option. Please enter a number");
	}

    }

    /**
     * Attempts to create a new row in our vehicle table
     * 
     * @throws SQLException
     */
    private void createRow() throws SQLException {
	System.out.print("\n\nPlease enter the id you would like to create: #");
	int vehicleId = scanner.nextInt();
	System.out.print("Enter new Make: ");
	String make = scanner.next().trim();
	System.out.print("Enter new Model: ");
	String model = scanner.next().trim();
	System.out.print("Enter new Year: ");
	String year = scanner.next().trim();

	String query = String.format("insert into vehicles values (%o, '%s', '%s', '%s')", vehicleId, make, model,
		year);
	System.out.println(query);
	stmt.executeUpdate(query);

    }

    /**
     * Closes the connection to the database and closes the scanner as well
     * 
     * @throws SQLException
     */
    private void close() throws SQLException {
	rs.close();
	stmt.close();
	conn.close();
	scanner.close();
	System.out.println("\n *** Disconnected from Database. ***");
    }

    /**
     * Handles the setup so we can private all our functions
     */
    public static void run() {
	try {
	    DBConnector DBC = new DBConnector();
	    int option = 0;

	    do {
		System.out.println("\n");
		System.out.println(
			"*** Menu Options ***\n1. Display All The Data!\n2. Update a row\n3. Delete a row\n4. Create a row\n5. Exit the program");
		System.out.print("\n Please enter an option (1-5): ");
		option = scanner.nextInt();

		switch (option) {
		case 1:
		    DBC.readTable();
		    break;
		case 2:
		    DBC.updateValue();
		    break;
		case 3:
		    DBC.deleteRow();
		    break;
		case 4:
		    DBC.createRow();
		    break;
		case 5:
		    DBC.close();
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
