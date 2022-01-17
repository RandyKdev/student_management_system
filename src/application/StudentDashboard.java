package application;

import java.io.IOException;
import database.enrollDB;
import database.studentDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentDashboard {
	@FXML
	private TableView<CourseListTable> table;
	@FXML
	private TableColumn<CourseListTable, String> title_clm;
	@FXML
	private TableColumn<CourseListTable, Integer> marks_clm;
	@FXML
	private TableColumn<LecturerListTable, String> code_clm;
	
	static ObservableList<CourseListTable> rows = FXCollections.observableArrayList();
	private int uid;
	
	@FXML
	private void onLogout(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
		LoginLogic ll = new LoginLogic();
		ll.show();
	}
	
	public void set(int id) {
		this.uid = id;
		
		enrollDB edb = new enrollDB();
		ObservableList<CourseListTable> plain = edb.getCourses(this.uid);
		
		title_clm.setCellValueFactory(new PropertyValueFactory<>("title"));
		code_clm.setCellValueFactory(new PropertyValueFactory<>("code"));
		marks_clm.setCellValueFactory(new PropertyValueFactory<>("marks"));
		
		rows = plain;
		table.setItems(rows);
	}
	public void show(int uid) {
		Parent root;
        try {
        	
        	studentDB sdb = new studentDB();
        	
        	if(!sdb.isAdmitted(uid)) {
        		StudentNotAdmitted st = new StudentNotAdmitted();
        		st.show();
        		
        	} else {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("student_dashboard.fxml"));
            root = loader.load();
            
            StudentDashboard sd = loader.getController();
            sd.set(uid);
                       
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        	}
        	}
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
