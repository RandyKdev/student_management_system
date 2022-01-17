package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import database.courseDB;
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

public class CourseList implements Initializable {
	@FXML
	private TableView<CourseListTable> table;
	@FXML
	private TableColumn<CourseListTable, String> code_clm;
	@FXML
	private TableColumn<CourseListTable, String> department_clm;
	@FXML
	private TableColumn<CourseListTable, String> title_clm;
	@FXML
	private TableColumn<CourseListTable, Integer> credit_value_clm;
	@FXML
	private TableColumn<CourseListTable, String> lecturer_clm;
	
	static ObservableList<CourseListTable> rows = FXCollections.observableArrayList();
	
	public void show() {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("list_course.fxml"));
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
		courseDB cdb = new courseDB();
		ObservableList<CourseListTable> ls = cdb.getCourses();
		
		code_clm.setCellValueFactory(new PropertyValueFactory<>("code"));
		department_clm.setCellValueFactory(new PropertyValueFactory<>("department"));
		title_clm.setCellValueFactory(new PropertyValueFactory<>("title"));
		lecturer_clm.setCellValueFactory(new PropertyValueFactory<>("lecturer"));
		credit_value_clm.setCellValueFactory(new PropertyValueFactory<>("credit_value"));
		
		rows = ls;
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
		                row = (TableRow) node.getParent();
		            }
		            System.out.println(rows.get(row.getIndex()));
		            AddCourse add = new AddCourse();
		    		add.show(table, rows.get(row.getIndex()));
		    		((Node)(event.getSource())).getScene().getWindow().hide();
		        }
		    }
		});
		
	
	}
	
	@FXML
	private void onCreate(ActionEvent event) {
		AddCourse add = new AddCourse();
		add.show(table, null);

		((Node)(event.getSource())).getScene().getWindow().hide();
	}
}
