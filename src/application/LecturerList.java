package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.lecturerDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
                       
            Stage stage = new Stage(); 
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            
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
	}
}
