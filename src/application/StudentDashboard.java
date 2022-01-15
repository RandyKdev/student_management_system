package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.courseDB;
import database.enrollDB;
import database.lecturerDB;
import database.studentDB;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
                       
            Stage stage = new Stage(); //(Stage)((Node)(event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            
            // Hide this current window (if this is what you want)
//            ((Node)(event.getSource())).getScene().getWindow().hide();
        	}
        	}
        catch (IOException e) {
            e.printStackTrace();
        }
	}


//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		
////		
////		table.setOnMousePressed((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
////		    @Override
////		    public void handle(MouseEvent event) {
////		        if (event.isPrimaryButtonDown()) {
////		            Node node = ((Node) event.getTarget()).getParent();
////		            TableRow row;
////		            if (node instanceof TableRow) {
////		                row = (TableRow) node;
////		            } else {
////		                // clicking on text part
////		                row = (TableRow) node.getParent();
////		            }
////		            studentDB student = new studentDB();
////		            
////		            student.updateStatus(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).status);
////		            
////		            rows.set(row.getIndex(), new StudentListTable(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).name, rows.get(row.getIndex()).status == 0 ? 1 : 0, rows.get(row.getIndex()).department, rows.get(row.getIndex()).cycle, rows.get(row.getIndex()).qualification));
////		           
////		            table.refresh();
////		            System.out.println("done");
////		        }
////		    }
////		});
//		
//	
//	}
}
