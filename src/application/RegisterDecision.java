package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	            
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root, 588, 324));
	            stage.show();
	            
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
