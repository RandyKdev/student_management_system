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
	private String port = "3306";
	
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
			sql = "DROP DATABASE " + dbName + ";";
			statement.execute(sql);
		}
			
		sql = "CREATE DATABASE " + dbName + ";";
		statement.execute(sql);
		sql = "use " + dbName + ";";
		statement.execute(sql);
		sql = "CREATE TABLE admin (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, created_at DATE NOT NULL);";
		statement.execute(sql);
		sql = "CREATE TABLE lecturer (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, level VARCHAR(50) NOT NULL, field VARCHAR(50) NOT NULL, created_at DATE NOT NULL);";
		statement.execute(sql);
		sql = "CREATE TABLE student (uid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, sex VARCHAR(1) NOT NULL, dob DATE NOT NULL, level INT NOT NULL, qualification VARCHAR(50) NOT NULL, status INT NOT NULL, cycle VARCHAR(100) NOT NULL, department VARCHAR(100), created_at DATE NOT NULL);";
		statement.execute(sql);
		sql = "CREATE TABLE course (code VARCHAR(6) PRIMARY KEY, title VARCHAR(100) NOT NULL, department VARCHAR(100) NOT NULL, credit_value INT NOT NULL, lecturer_id INT, created_at DATE NOT NULL, FOREIGN KEY (lecturer_id) REFERENCES lecturer(uid));";
		statement.execute(sql);
		sql = "CREATE TABLE enroll (student_id INT, course_id VARCHAR(6), marks INT, PRIMARY KEY(student_id, course_id), FOREIGN KEY (student_id) REFERENCES student(uid), FOREIGN KEY (course_id) REFERENCES course(code));";
		statement.execute(sql);
		
		// loads dummy Data
		new dummyDB();
		
		connection.close();
	}
	
	// gets db connection
	public Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName, userName, pwd);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/", userName, pwd);
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
