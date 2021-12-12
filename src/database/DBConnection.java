package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection connection;
	private String userName = "sdt";
	private String pwd = "sdtproject";
	private String dbName = "sunshine";
	
	// instantiates Database
	public void instantiateDB() throws SQLException {	
		createConnection();
		if(connection == null) throw new SQLException("Error creating connection to db");
		Statement statement;
		boolean found = false;
			statement = connection.createStatement();
			ResultSet rs = connection.getMetaData().getCatalogs();
			while(rs.next()) {
				if(dbName.equals(rs.getString(1))) {
					found = true;
				}
			}
			if(!found) {
			String sql = "CREATE DATABASE sunshine;";
			statement.execute(sql);
			statement.execute(sql);
			}
		connection.close();
	}
	
	// gets sunshine db connection
	public Connection getDbConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(connection == null) throw new SQLException("Error creating connection to db");
		return connection;
	}
	
	
	// Gets initial db connection
	private void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, pwd);
			if(connection== null) throw new SQLException("Error creating connection to db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
