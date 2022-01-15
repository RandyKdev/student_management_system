package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import database.courseDB;
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

public class LecturerDashboard {
	@FXML
	private TableView<CourseListTable> table;
	@FXML
	private TableColumn<CourseListTable, String> name_clm;
	@FXML
	private TableColumn<CourseListTable, String> uid_clm;
	
	static ObservableList<CourseListTable> rows = FXCollections.observableArrayList();
	private int uid;
	public void setUid(int uid) {
		this.uid = uid;
		
		courseDB sdb = new courseDB();
		ObservableList<CourseListTable> ls = sdb.getCourses();
		
		name_clm.setCellValueFactory(new PropertyValueFactory<>("title"));
		uid_clm.setCellValueFactory(new PropertyValueFactory<>("code"));
		rows = ls;
		 List<CourseListTable>  rows1 = rows.stream()
        .filter(t -> t.lecturer == this.uid)// this.uid)
        .collect(Collectors.toList());
		 
		 rows = FXCollections.observableArrayList();
		 rows1.forEach((e) -> rows.add(e));
		table.setItems(rows);
		
		table.setOnMousePressed((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown()) {
		            Node node = ((Node) event.getTarget()).getParent();
		            TableRow row;
		            if (node instanceof TableRow) {
		                row = (TableRow) node;
		            } else {
		                // clicking on text part
		                row = (TableRow) node.getParent();
		            }
		            
		            LecturerStudentList ls1 = new LecturerStudentList();
		            ls1.show(rows.get(row.getIndex()).code);
		            System.out.println(rows.get(row.getIndex()).code);
//		            rows.get(row.getIndex()).code;
//		            studentDB student = new studentDB();
//		            
//		            student.updateStatus(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).status);
//		            
//		            rows.set(row.getIndex(), new StudentListTable(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).name, rows.get(row.getIndex()).status == 0 ? 1 : 0, rows.get(row.getIndex()).department, rows.get(row.getIndex()).cycle, rows.get(row.getIndex()).qualification));
//		           
//		            table.refresh();
		            System.out.println(rows.get(row.getIndex()).code);
		        }
		    }
		});
	}
	public void show(int uid) {
		Parent root;
        try {
    		courseDB sdb = new courseDB();
        	ObservableList<CourseListTable> ls = sdb.getCourses();
    		
    		 List<CourseListTable>  rows1 = ls.stream()
            .filter(t -> t.lecturer == uid)// this.uid)
            .collect(Collectors.toList());
    		 
    		 System.out.println(rows1.toArray().length);
    		 if(rows1.toArray().length == 0) {
    			 LectureNoCourse ll = new LectureNoCourse();
    				ll.show();
    	            return;
    		 }
    		 
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("lecturer_dashboard.fxml"));
            root = loader.load();
            
            LecturerDashboard ld = loader.getController();
            ld.setUid(uid);
                       
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
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		courseDB sdb = new courseDB();
//		ObservableList<CourseListTable> ls = sdb.getCourses();
//		
//		name_clm.setCellValueFactory(new PropertyValueFactory<>("title"));
//		uid_clm.setCellValueFactory(new PropertyValueFactory<>("code"));
//		rows = ls;
//		 List<CourseListTable>  rows1 = rows.stream()
//        .filter(t -> t.lecturer == this.uid)// this.uid)
//        .collect(Collectors.toList());
//		 
//		 rows = FXCollections.observableArrayList();
//		 rows1.forEach((e) -> rows.add(e));
//		table.setItems(rows);
//		
//		table.setOnMousePressed((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
//		    @Override
//		    public void handle(MouseEvent event) {
//		        if (event.isPrimaryButtonDown()) {
//		            Node node = ((Node) event.getTarget()).getParent();
//		            TableRow row;
//		            if (node instanceof TableRow) {
//		                row = (TableRow) node;
//		            } else {
//		                // clicking on text part
//		                row = (TableRow) node.getParent();
//		            }
//		            
//		            LecturerStudentList ls1 = new LecturerStudentList();
//		            ls1.show(rows.get(row.getIndex()).code);
//		            System.out.println(rows.get(row.getIndex()).code);
////		            rows.get(row.getIndex()).code;
////		            studentDB student = new studentDB();
////		            
////		            student.updateStatus(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).status);
////		            
////		            rows.set(row.getIndex(), new StudentListTable(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).name, rows.get(row.getIndex()).status == 0 ? 1 : 0, rows.get(row.getIndex()).department, rows.get(row.getIndex()).cycle, rows.get(row.getIndex()).qualification));
////		           
////		            table.refresh();
//		            System.out.println(rows.get(row.getIndex()).code);
//		        }
//		    }
//		});
//
//	}
	
	@FXML
	private void onLogout(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
		LoginLogic ll = new LoginLogic();
		ll.show();
	}
}
