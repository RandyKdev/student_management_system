package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Student;
import application.StudentListTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

public class studentDB {
	public ObservableList<StudentListTable> getStudents() {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "SELECT * FROM student;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			ObservableList<StudentListTable> ls = FXCollections.observableArrayList();
			
			 while(result.next()) {
				 ls.add(new StudentListTable(result.getInt("uid"), result.getString("name"), result.getInt("status"), result.getString("department"), result.getString("cycle"), result.getString("qualification")));
			 }
			 return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean onLogin(String email, String pwd) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "SELECT email, password FROM student "
				     + "WHERE email = ? AND password = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, pwd);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				connection.close();
				return true;
			}
			
			connection.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean exists(String email) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql =  "SELECT email FROM student "
				     + "WHERE email = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				connection.close();
				return true;
			}
			
			connection.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean onAdd(String email, String pwd, String name, Date dob, String sex, int level, String qualification, int status, String cycle, String department) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "INSERT INTO student"
					+ "(email, password, name, dob, sex, level, qualification, status, cycle, department, created_at)"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, pwd);
			statement.setString(3, name);
			statement.setDate(4, dob);
			statement.setString(5, sex);
			statement.setInt(6, level);
			statement.setString(7, qualification);
			statement.setInt(8, status);
			statement.setString(9, cycle);
			statement.setString(10, department);
			
			long millis=System.currentTimeMillis();
		    Date date=new Date(millis);
		   
			statement.setDate(11, date);
			
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePassword(String email, String pwd) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "UPDATE student "
					+ "SET password = ? "
					+ "WHERE email = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pwd);
			statement.setString(2, email);
			
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateStatus(int student_id, int status) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "UPDATE student "
					+ "SET status = ? "
					+ "WHERE uid = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, student_id);
			
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
