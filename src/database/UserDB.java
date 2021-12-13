package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
	public boolean onLogin(String email, String pwd) {
		DBConnection con = new DBConnection();
		Connection connection = con.getDbConnection();
		try {
			String sql = "SELECT email, password FROM user "
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
}
