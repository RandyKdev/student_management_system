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

public class LoginDecision {
	public String email;
	public String pwd;
	public ActionEvent previousEvent;
	
	@FXML
	private void admin(MouseEvent event) {
		   adminDB userDB = new adminDB();
		   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn) {
		
			  AdminDashboard adminDash = new AdminDashboard();
			  adminDash.show();
			  
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
		   int loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn > 0) {
			   StudentDashboard ld = new StudentDashboard();
			   ld.show(loggedIn);
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
		   int loggedIn = userDB.onLogin(email.trim(), pwd);
		   if(loggedIn > 0) {
			   LecturerDashboard ld = new LecturerDashboard();
			   ld.show(loggedIn);
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
	        	           
	            Stage stage = new Stage(); 
	            stage.setScene(new Scene(root, 588, 324));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
