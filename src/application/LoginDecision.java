package application;

import java.io.IOException;

import database.adminDB;
import database.lecturerDB;
import database.studentDB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.*;

public class LoginDecision {
	public String email;
	public String pwd;
	public ActionEvent previousEvent;
	
	@FXML
	private void admin(MouseEvent event) {
		   adminDB userDB = new adminDB();
		   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn) {
			   SuccessScreen successScreen = new SuccessScreen();
			   successScreen.show("Successfully signed in as an admin");
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("Email or Password Incorrect", "If it persists consider registering or resetting your password");
		   }
	}
	
	@FXML
	private void student(MouseEvent event) {
		   studentDB userDB = new studentDB();
		   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn) {
			   SuccessScreen successScreen = new SuccessScreen();
			   successScreen.show("Successfully signed in as a student");
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("Email or Password Incorrect", "If it persists consider registering or resetting your password");
		   }
	}
	
	@FXML
	private void lecturer(MouseEvent event) {
		   lecturerDB userDB = new lecturerDB();
		   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn) {
			   SuccessScreen successScreen = new SuccessScreen();
			   successScreen.show("Successfully signed in as a lecturer");
			   ((Node)(event.getSource())).getScene().getWindow().hide();
			   ((Node)(previousEvent.getSource())).getScene().getWindow().hide();
		   } else {
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("Email or Password Incorrect", "If it persists consider registering or resetting your password");
		   }
	}
	
	public void show(ActionEvent event, String emailGiven, String pwdGiven) {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("login_decision.fxml"));
	            root = loader.load();
	            
	            LoginDecision loginDecision = loader.getController();
	            
	            loginDecision.email = emailGiven;
	            loginDecision.pwd = pwdGiven;
	            loginDecision.previousEvent = event;
	        	           
	            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
	            stage.setScene(new Scene(root, 588, 324));
	            stage.show();
	            
	            // Hide this current window (if this is what you want)
//	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
