package application;

import java.io.IOException;
import database.enrollDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.Node;

public class AddMark {
	@FXML
	private TextField mark_field;
	
	private int student_id;
	private String course_code;
	private MouseEvent event;
	
	@FXML
	private void onDone(ActionEvent event) {
		  enrollDB edb = new enrollDB();
		  edb.update( course_code,student_id,Integer.parseInt(mark_field.getText()));
		 
		  ((Node)(this.event.getSource())).getScene().getWindow().hide();
		  ((Node)(event.getSource())).getScene().getWindow().hide();
		  
		  LecturerStudentList ls = new LecturerStudentList();
		  ls.show(this.course_code);
	}
	
	public void set(int student_id, String course_code, int mark, MouseEvent evt) {
		this.student_id = student_id;
		this.course_code = course_code;
		this.mark_field.setText(Integer.toString(mark));
		this.event = evt;
	}
	public void show(int student_id, String course_code, MouseEvent event) {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("add_mark.fxml"));
            root = loader.load();
            
            AddMark add = loader.getController();
            enrollDB edb = new enrollDB();
           
            add.set(student_id, course_code,  edb.getMark(course_code, student_id), event);
                       
            Stage stage = new Stage(); 
            stage.setScene(new Scene(root, 443, 175));
            stage.show();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
