
public class LoginInfo {

    private String userName;
    private String userPass;
    private String driver;
    private String dbType;
    private String ip;
    private String port;
    private String database;
    private String table;

    /**
     * Two constructors:
     * <p>
     * 1. Requires specific details (ie drivers, table names, etc)
     * <p>
     * 2. Takes no params and sets default values to my local database
     * 
     * @param userName UserName with access to the database
     * @param userPass Password for the UserName account
     * @param driver   The Type of driver (ie "jdbc")
     * @param dbType   The type of database (ie mongo, mysql)
     * @param ip       The hosts IP (127.0.0.1)
     * @param port     Port the database lives on (Default: 3306)
     * @param database The database we would like to connect to!
     * @param table    The table to modify data on
     */
    public LoginInfo(String userName, String userPass, String driver, String dbType, String ip, String port,
	    String database, String table) {
	this.userName = userName;
	this.userPass = userPass;
	this.driver = driver;
	this.dbType = dbType;
	this.ip = ip;
	this.port = port;
	this.database = database;
	this.table = table;
    }

    public LoginInfo() {
	userName = "promineoadmin";
	userPass = "promineoadmin";
	driver = "jdbc";
	dbType = "mysql";
	ip = "localhost";
	port = "3306";
	database = "promineotech";
	table = "vehicles";
    }

    /**
     * String used for our connection, formats driver, db type, ip, port, database
     * 
     * @return Connection URL: String
     */
    public String getFullUrl() {
	return String.format("%s:%s://%s:%s/%s", driver, dbType, ip, port, database);
    }

    public String getUserName() {
	return userName;
    }

    public String getUserPass() {
	return userPass;
    }

    public String getDatabase() {
	return database;
    }

    /**
     * Can be used to show which table you are working on
     * 
     * @return Table Name: String
     */
    public String getTable() {
	return table;
    }

    /**
     * Can be used to switch tables you are working on
     * 
     * @param table
     */
    public void setTable(String table) {
	this.table = table;
    }

}
