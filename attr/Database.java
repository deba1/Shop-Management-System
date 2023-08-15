package attr;

import java.sql.*;

public final class Database {
	public static final String HOST_URI = "jdbc:mysql://localhost:3306/f1";
	public static final String USER = "root";
	public static final String PASSWORD = "";

	private static Database instance = null;

	private Database(){};

	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}

	private Connection getConnectionDB() throws SQLException {
		return DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
	}

	private Statement createStatement() throws SQLException {
		return getConnectionDB().createStatement();
	}

	public boolean execute(String query) throws SQLException {
		createStatement().execute(query);
		return true;
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return createStatement().executeQuery(query);
	}

	public int executeUpdate(String query) throws SQLException {
		return createStatement().executeUpdate(query);
	}
}