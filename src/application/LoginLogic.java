package application;

import database.UserDB;
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
		   // return error screen
	   }
	   
	   System.out.println("Login Clicked");
	   
	   UserDB userDB = new UserDB();
	   boolean loggedIn = userDB.onLogin(email.trim(), pwd);
	   if(loggedIn) {
		   
		   // remove current screen and navigate to appropriate screen
	   } else {
		   // show error screen
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
