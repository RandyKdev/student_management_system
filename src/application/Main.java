package application;
	
import java.sql.Connection;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			 Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); // for login
//			 Scene scene = new Scene(root,600,400); // for login
//			Parent root = FXMLLoader.load(getClass().getResource("error.fxml")); // for error
//			Scene scene = new Scene(root,640,285); // for error
//			Parent root = FXMLLoader.load(getClass().getResource("forgot_password.fxml")); // for forgot password
//			Scene scene = new Scene(root,699,249); // for forgot password
//			Parent root = FXMLLoader.load(getClass().getResource("new_password.fxml")); // for new password
//			Scene scene = new Scene(root,600,237); // for new password
//			Parent root = FXMLLoader.load(getClass().getResource("register_decision.fxml")); // for register decision
//			Scene scene = new Scene(root,588,324); // for register decision
//			Parent root = FXMLLoader.load(getClass().getResource("register_lecturer.fxml")); // for register lecturer
//			Scene scene = new Scene(root,600,500); // for register lecturer
//			Parent root = FXMLLoader.load(getClass().getResource("register_admin.fxml")); // for register admin
//			Scene scene = new Scene(root,600,355); // for register admin
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			DBConnection dbConnection = new DBConnection();
			dbConnection.instantiateDB();
			Connection con =dbConnection.getDbConnection();
			if(con != null) System.out.println("connected");
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
