package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminDashboard {
	@FXML
	private void show_students(MouseEvent event) {
		StudentList sl = new StudentList();
		sl.show();
	}
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_dashboard.fxml"));
	            root = loader.load();
	            
	            loader.getController();
	                       
	            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
	            stage.setScene(new Scene(root, 779, 613));
	            stage.show();
	            
	            // Hide this current window (if this is what you want)
//	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
