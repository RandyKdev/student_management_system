package application;

import database.adminDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
//		   return;
		   ErrorScreen errorScreen = new ErrorScreen();
		   errorScreen.show(event, "Email not in right format", "Try entering a correct email");
		   return;
	   }
	   
	   System.out.println("Login Clicked");
	   
	   adminDB userDB = new adminDB();
	   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
	   if(loggedIn) {
		   
		   // remove current screen and navigate to appropriate screen
	   } else {
		   // show error screen
		   ErrorScreen errorScreen = new ErrorScreen();
		   errorScreen.show(event, "Email or Password Incorrect", "If it persists consider registering or resetting your password");
		   return;
	   }
   }
	@FXML
   private void onRegister(ActionEvent event) {
	   System.out.println("Register Clicked");
   }
	@FXML
   private void onForgotPwd(ActionEvent event) {
	   System.out.println("Forgot Password Clicked");
   }
	@FXML
	private void onPwdFieldChange() {
		System.out.println("pwd changes");
	}
}
