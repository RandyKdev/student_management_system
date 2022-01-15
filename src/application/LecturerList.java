package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.lecturerDB;
import database.studentDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class LecturerList implements Initializable {
	@FXML
	private TableView<LecturerListTable> table;
	@FXML
	private TableColumn<LecturerListTable, String> name_clm;
	@FXML
	private TableColumn<LecturerListTable, String> field_clm;
	@FXML
	private TableColumn<LecturerListTable, String> level_clm;
	@FXML
	private TableColumn<LecturerListTable, Integer> uid_clm;
	
	static ObservableList<LecturerListTable> rows = FXCollections.observableArrayList();
	
	public void show() {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("list_lecturer.fxml"));
            root = loader.load();
            
            loader.getController();
                       
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lecturerDB sdb = new lecturerDB();
		ObservableList<LecturerListTable> ls = sdb.getLecturers();
		
		name_clm.setCellValueFactory(new PropertyValueFactory<>("name"));
		level_clm.setCellValueFactory(new PropertyValueFactory<>("level"));
		field_clm.setCellValueFactory(new PropertyValueFactory<>("field"));
		uid_clm.setCellValueFactory(new PropertyValueFactory<>("lecturer_id"));
		rows = ls;
		table.setItems(rows);
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
//		            studentDB student = new studentDB();
//		            
//		            student.updateStatus(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).status);
//		            
//		            rows.set(row.getIndex(), new StudentListTable(rows.get(row.getIndex()).student_id, rows.get(row.getIndex()).name, rows.get(row.getIndex()).status == 0 ? 1 : 0, rows.get(row.getIndex()).department, rows.get(row.getIndex()).cycle, rows.get(row.getIndex()).qualification));
//		           
//		            table.refresh();
//		            System.out.println("done");
//		        }
//		    }
//		});
		
	
	}
}
