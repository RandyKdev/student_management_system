package application;
	
import java.sql.Connection;

import database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			//Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
			//Scene scene = new Scene(root,600,400);
//			 Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); // for login
//			 Scene scene = new Scene(root,600,400); // for login
			Parent root = FXMLLoader.load(getClass().getResource("registrationResult.fxml")); // for error
			Scene scene = new Scene(root,640,285); // for error
//			Parent root = FXMLLoader.load(getClass().getResource("forgot_password.fxml")); // for forgot password
//			Scene scene = new Scene(root, 699, 249); // for forgot password
//			Parent root = FXMLLoader.load(getClass().getResource("new_password.fxml")); // for new password
//			Scene scene = new Scene(root, 600, 237); // for new password
//			Parent root = FXMLLoader.load(getClass().getResource("register_decision.fxml")); // for register decision
//			Scene scene = new Scene(root,588,324); // for register decision

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sunshine");
			primaryStage.setResizable(false);
			primaryStage.show();
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
