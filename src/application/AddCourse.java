package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.courseDB;
import database.lecturerDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddCourse {
	@FXML
	private TextField code_field;
	@FXML
	private TextField title_field;
	@FXML
	private ComboBox<String> lecturer_field;
	@FXML
	private ComboBox<String> department_field;
	@FXML
	private TextField credit_value_field;
	@FXML
	private Button btn;
	
	private String oldcoursecode;
	private TableView<CourseListTable> table;
	private CourseListTable course;
	private ObservableList<String> lecturers = FXCollections.observableArrayList();
//	ObservableList<String> lecturers_show = FXCollections.observableArrayList();
	
	public void injectTable(TableView<CourseListTable> table, CourseListTable course1) {
		this.table = table;
		this.course = course1;
	}
	
	public void show(TableView<CourseListTable> table, CourseListTable course) {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("new_course.fxml"));
            root = loader.load();
            
            AddCourse add = loader.getController();
            System.out.println(course);
            add.injectTable(table, course);
            add.initialize();
                       
            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            
            // Hide this current window (if this is what you want)
//            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
//	@Override
	public void initialize() {
		String s[] = {"Computer Eng", "Electrical Eng"}; 
		 department_field.setItems(FXCollections.observableArrayList(s));
		 
		lecturerDB lecturer = new lecturerDB();
		lecturers = lecturer.getLecturersName();
		lecturer_field.setItems(lecturers);
		
		if(course != null) {
			oldcoursecode = course.code;
			code_field.setText(course.code);
			code_field.setEditable(false);
			title_field.setText(course.title);
			department_field.setValue(course.department);
//			department_field.setText(course.department);\
			credit_value_field.setText(String.valueOf(course.credit_value));
			lecturer_field.setValue(CourseListTable.getLecturer1(course.lecturer));
			btn.setText("Update");
		}
	
	}
	
	@FXML
	private void onAdd(ActionEvent evt) {
		if(course == null) {
			courseDB crs = new courseDB();
			crs.onAdd(code_field.getText(), title_field.getText(), lecturers.indexOf(lecturer_field.getValue()), department_field.getValue(), Integer.valueOf(credit_value_field.getText()));
			((Node)(evt.getSource())).getScene().getWindow().hide();
			CourseList cr = new CourseList();
			cr.show();
//			this.table.refresh();
			return;
		} else {
			courseDB crs = new courseDB();
			crs.update(oldcoursecode, title_field.getText(), department_field.getValue(), lecturers.indexOf(lecturer_field.getValue()), Integer.parseInt(credit_value_field.getText()));
			((Node)(evt.getSource())).getScene().getWindow().hide();
			CourseList cr = new CourseList();
			cr.show();
//			this.table.refresh();
			return;
		
		}
	}
	
}
