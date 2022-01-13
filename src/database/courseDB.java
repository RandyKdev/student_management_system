package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.CourseListTable;
import application.StudentListTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class courseDB {
	public ObservableList<StudentListTable> getCoursesFromDepartment(String department) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "SELECT * FROM course WHERE department = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, department);
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
	public ObservableList<CourseListTable> getCourses() {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "SELECT * FROM course;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			ObservableList<CourseListTable> ls = FXCollections.observableArrayList();
			
			 while(result.next()) {
				 ls.add(new CourseListTable(result.getString("code"), result.getString("title"), result.getString("department"), result.getInt("credit_value"), result.getInt("lecturer_id")));
			 }
			 return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean exists(String code) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql =  "SELECT code FROM course "
				     + "WHERE code = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, code);
			
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
	
	public boolean onAdd(String code, String title, int lecturer_id, String department, int credit_value) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "INSERT INTO course"
					+ "(code, title, lecturer_id, department, credit_value, created_at)"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, code);
			statement.setString(2, title);
			statement.setInt(3, lecturer_id);
			statement.setString(4, department);
			statement.setInt(5, credit_value);
			
			long millis=System.currentTimeMillis();
		    Date date=new Date(millis);
		   
			statement.setDate(6, date);
			
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(String code, String title, String department, int lecturer_id, int credit_value) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "UPDATE course "
					+ "SET title = ?, department = ?, lecturer_id = ?, credit_value = ? "
					+ "WHERE code = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, department);
			statement.setInt(3, lecturer_id);
			statement.setInt(4, credit_value);
			statement.setString(5, code);
			
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
