package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginLogic {
	public LoginLogic() {}
	
	
	@FXML
   private TextField login_screen_email_field;
	@FXML
	private TextField login_screen_password_field;
	@FXML
	private TextField login_screen_type_field;
	@FXML
   private void onLogin(ActionEvent event) {
	   String email = login_screen_email_field.getText();
	   String pwd = login_screen_password_field.getText();
	   
	   if(!EmailValidator.isValid(email)) {
		   ErrorScreen errorScreen = new ErrorScreen();
		   errorScreen.show("Email not in right format", "Try entering a correct email");
		   return;
	   }
	   
	   System.out.println("Login Clicked");
	   
	   LoginDecision loginDecision = new LoginDecision();
	   loginDecision.show(event, email.trim(), pwd);
   }
	@FXML
   private void onRegister(ActionEvent event) {
	   RegisterDecision registerDecision = new RegisterDecision();
	   registerDecision.show();
   }
	
	@FXML
   private void onForgotPwd(ActionEvent event) {
		ForgotPassword forgotPassword = new ForgotPassword();
		forgotPassword.show();
   }
	
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	            root = loader.load();
	            
	            loader.getController();
	                       
	            Stage stage = new Stage(); 
	            stage.setScene(new Scene(root, 600, 400));
	            stage.show();
	            
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
