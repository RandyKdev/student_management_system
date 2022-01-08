package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

import database.adminDB;
import database.lecturerDB;
import database.studentDB;
import javafx.event.ActionEvent;

public class NewPassword {
	public String email;
	public int auth; // 1 = admin, 2 = lecturer, 3 = student
	@FXML
	private PasswordField pwd_field;
	@FXML
	private PasswordField knfrm_pwd_field;
	
	@FXML
	private void onReset(ActionEvent event) {
		String pwd = pwd_field.getText();
		String knfrm_pwd = knfrm_pwd_field.getText();
		
		if(pwd.isBlank()) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("Password Field Empty", "Please enter a password");
			 return;
		}
		
		if(pwd.compareTo(knfrm_pwd) != 0) {
			ErrorScreen errorScreen = new ErrorScreen();
			errorScreen.show("Passwords Donot Match", "Check your entries for the passwords");
			return;
		}
		
		if(auth == 0) {
			adminDB adminDb = new adminDB();
			adminDb.updatePassword(email, pwd);
		} else if(auth == 1) {
			lecturerDB lecturerDb = new lecturerDB();
			lecturerDb.updatePassword(email, pwd);
		} else {
			studentDB studentDb = new studentDB();
			studentDb.updatePassword(email, pwd);
		}
		
		((Node)(event.getSource())).getScene().getWindow().hide();
		SuccessScreen successScreen = new SuccessScreen();
		successScreen.show("Successfully resetted password");
	}
	
	public void show(String emailGiven, int auth) {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("new_password.fxml"));
	            root = loader.load();
	            
	            NewPassword newPassword = loader.getController();
	            
	            newPassword.auth = auth;
	            newPassword.email = emailGiven;
	            
	            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
	            stage.setScene(new Scene(root, 600, 237));
	            stage.show();
	            
	            // Hide this current window (if this is what you want)
//	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
