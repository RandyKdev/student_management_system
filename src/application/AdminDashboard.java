package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminDashboard {
	@FXML
	private void show_students(MouseEvent event) {
		StudentList sl = new StudentList();
		sl.show();
	}
	@FXML
	private void show_courses(MouseEvent event) {
		CourseList sl = new CourseList();
		sl.show();
	}
	@FXML
	private void show_lecturers(MouseEvent event) {
		LecturerList sl = new LecturerList();
		sl.show();
	}
	@FXML
	private void onLogout(MouseEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
		LoginLogic lg = new LoginLogic();
		
		lg.show();
	}
	public void show() {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_dashboard.fxml"));
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
