package application;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import database.lecturerDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterLecturer {
	@FXML
	private TextField first_name_field;
	@FXML
	private TextField last_name_field;
	@FXML
	private ComboBox<String> sex_field;
	@FXML
	private DatePicker dob_field;
	@FXML
	private TextField email_field;
	@FXML
	private PasswordField pwd_field;
	@FXML
	private PasswordField knfrm_pwd_field;
	@FXML
	private TextField level_field;
	@FXML
	private TextField field_field;
	
	
	public void setComboBox() {
		String s[] = {"M", "F"}; 
		 sex_field.setItems(FXCollections.observableArrayList(s));
	}
	
	@FXML
	private void onRegister(ActionEvent event) {
		String first_name = first_name_field.getText();
		String last_name = last_name_field.getText();
		String email = email_field.getText();
		String pwd = pwd_field.getText();
		String knfrm_pwd = knfrm_pwd_field.getText();
		LocalDate dob = dob_field.getValue();
		String level = level_field.getText();
		String field = field_field.getText();

		// Checks
		if(first_name.isBlank()) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("First Name Empty", "Please enter your first name");
			 return;
		}
		
		if(last_name.isBlank()) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("Last Name Empty", "Please enter your last name");
			 return;
		}
		
		String sex = sex_field.getValue();
		if(!(sex.compareTo("M") == 0 || sex.compareTo("F") == 0)) {
			ErrorScreen errorScreen = new ErrorScreen();
			errorScreen.show("Invalid sex", "Please choose your sex from the dropdown");
			return;
		}
		
		if(dob == null) {
			ErrorScreen errorScreen = new ErrorScreen();
			errorScreen.show("Enter Date of Birth", "Please enter your birth date");
			return;
		}
		
		int month = dob.getMonthValue();
		int day = dob.getDayOfMonth();
		int year = dob.getYear();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
			
	    Date date=new Date(cal.getTimeInMillis());
		
		cal = Calendar.getInstance();
		if(date.compareTo(new Date(cal.getTimeInMillis())) >= 0) {
			ErrorScreen errorScreen = new ErrorScreen();
			errorScreen.show("Incorrect Birth Date", "Please enter your correct date of birth");
			return;
		}
		
		if(!EmailValidator.isValid(email)) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("Email not in right format", "Try entering a correct email");
			 return;
		}
		
		lecturerDB lecturerDb = new lecturerDB();
		if(lecturerDb.exists(email)) {
			ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("A lecturer with that email already exists", "Try logging in instead");
			 return;
		}
		
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
		
		if(level.isBlank()) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("Level Empty", "Please enter your level");
			 return;
		}
		
		if(field.isBlank()) {
			 ErrorScreen errorScreen = new ErrorScreen();
			 errorScreen.show("Field Empty", "Please enter your field");
			 return;
		}
		
		lecturerDb.onAdd(email, pwd, first_name + ' ' + last_name, date, sex, level, field);
		
		SuccessScreen success = new SuccessScreen();
		success.show("Successfully created a lecturer account. You can now login with that account");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("register_lecturer.fxml"));
	            root = loader.load();
	            
	            RegisterLecturer registerLecturer = loader.getController();
	            registerLecturer.setComboBox();
	            
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root, 600, 400));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
