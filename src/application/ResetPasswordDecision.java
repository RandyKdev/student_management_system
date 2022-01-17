package application;

import java.io.IOException;

import database.adminDB;
import database.lecturerDB;
import database.studentDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.*;

public class ResetPasswordDecision {
	public String email;
	public ActionEvent previousEvent;
	
	@FXML
	private void admin(MouseEvent event) {
		   adminDB userDB = new adminDB();
		   boolean exists = userDB.exists(email.trim());
		   if(exists) {
			   NewPassword newPassword = new NewPassword();
			   newPassword.show(email, 0);
			   
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("User Not Found", "Admin with email, " + email + " not found");
		   }
	}
	
	@FXML
	private void student(MouseEvent event) {
		   studentDB userDB = new studentDB();
		   boolean exists = userDB.exists(email.trim());
		   if(exists) {
			   NewPassword newPassword = new NewPassword();
			   newPassword.show(email, 2);
			   
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("User Not Found", "Student with email, " + email + " not found");
		   }
	}
	
	@FXML
	private void lecturer(MouseEvent event) {
		   lecturerDB userDB = new lecturerDB();
		   boolean exists = userDB.exists(email.trim());
		   if(exists) {
			   NewPassword newPassword = new NewPassword();
			   newPassword.show(email, 1);
			   
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("User Not Found", "Lecturer with email, " + email + " not found");
		   }
	}
	
	public void show(ActionEvent event, String emailGiven) {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("reset_password_decision.fxml"));
	            root = loader.load();
	            
	            ResetPasswordDecision resetPasswordDecision = loader.getController();
	            
	            resetPasswordDecision.email = emailGiven;
	            resetPasswordDecision.previousEvent = event;
	        	
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root, 588, 324));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}

