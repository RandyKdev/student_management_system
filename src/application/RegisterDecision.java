package application;

import java.io.IOException;

import database.adminDB;
import database.lecturerDB;
import database.studentDB;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterDecision {
	@FXML
	private void admin(MouseEvent event) {
		   RegisterAdmin admin = new RegisterAdmin();
		   admin.show();
		   ((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	private void student(MouseEvent event) {

		RegisterStudent student = new RegisterStudent();
		student.show();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	private void lecturer(MouseEvent event) {
		RegisterLecturer lecturer = new RegisterLecturer();
		lecturer.show();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("register_decision.fxml"));
	            root = loader.load();
	            
	            loader.getController();
	            
	            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
	            stage.setScene(new Scene(root, 588, 324));
	            stage.show();
	            
//	            Hide this current window (if this is what you want)
//	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
