package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotPassword {
	@FXML
	private TextField email_field;
	
	@FXML
	private void onForgot(ActionEvent event) {
		String email = email_field.getText();
		
		if(!EmailValidator.isValid(email)) {
//			   return;
			   ErrorScreen errorScreen = new ErrorScreen();
			   errorScreen.show("Email not in right format", "Try entering a correct email");
			   return;
		 }
		
		ResetPasswordDecision resetDecision = new ResetPasswordDecision();
		resetDecision.show(event, email);
	}
	
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("forgot_password.fxml"));
	            root = loader.load();
	            
	            loader.getController();
	                       
	            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
	            stage.setScene(new Scene(root, 699, 249));
	            stage.show();
	            
	            // Hide this current window (if this is what you want)
//	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
