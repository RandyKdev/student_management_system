package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class enrollDB {
	public boolean exists(String ccode, int student_id) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql =  "SELECT * FROM enroll "
				     + "WHERE course_id = ? AND student_id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ccode);
			statement.setInt(2, student_id);
			
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
	
	public boolean onEnroll(String ccode, int student_id) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "INSERT INTO enroll"
					+ "(course_id, student_id, marks)"
					+ "VALUES"
					+ "(?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ccode);
			statement.setInt(2, student_id);
			statement.setInt(3, 0);
			
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(String ccode, int student_id, int marks) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "UPDATE enroll "
					+ "SET marks = ? "
					+ "WHERE course_id = ? AND student_id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, marks);
			statement.setString(2, ccode);
			statement.setInt(3, student_id);
			
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
