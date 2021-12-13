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
   private void onLogin(ActionEvent event) {
	   String email = login_screen_email_field.getText();
	   String pwd = login_screen_password_field.getText();
	   System.out.println("Login Clicked");
	   
	   UserDB userDB = new UserDB();
	   boolean done = userDB.onLogin(email.trim(), pwd);
	   System.out.println(done);
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
