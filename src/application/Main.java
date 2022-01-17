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
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); // for login
			Scene scene = new Scene(root, 600, 400); // for login
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sunshine");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			// Instantiates Database
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
