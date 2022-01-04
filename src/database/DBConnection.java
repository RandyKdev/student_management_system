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
		String sql;
		boolean found = false;
		statement = connection.createStatement();
		ResultSet rs = connection.getMetaData().getCatalogs();
		while(rs.next()) {
			if(dbName.equals(rs.getString(1))) {
				found = true;
			}
		}
			
		if(found) {
			sql = "DROP DATABASE sunshine;";
			statement.execute(sql);
		}
			
		sql = "CREATE DATABASE sunshine;";
		statement.execute(sql);
		sql = "use sunshine;";
		statement.execute(sql);
		sql = "CREATE TABLE admin (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, created_at DATE NOT NULL);";
		statement.execute(sql);
		sql = "CREATE TABLE lecturer (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, level VARCHAR(50) NOT NULL, field VARCHAR(50) NOT NULL, created_at DATE NOT NULL);";
		statement.execute(sql);
		sql = "CREATE TABLE student (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, level INT NOT NULL, qualification VARCHAR(50) NOT NULL, created_at DATE NOT NULL);";
		statement.execute(sql);
		
		// loads dummy Data
		new dummyDB();
		
		connection.close();
	}
	
	// gets sunshine db connection
	public Connection getDbConnection() {
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
