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
}
