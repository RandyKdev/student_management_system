package application;

import java.io.IOException;
import database.courseDB;
import database.enrollDB;
import database.studentDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LecturerStudentList {
	@FXML
	private TableView<StudentListTable> table;
	@FXML
	private TableColumn<StudentListTable, String> name_clm;
	@FXML
	private TableColumn<StudentListTable, Integer> marks_clm;
	@FXML
	private TableColumn<StudentListTable, Integer> uid_clm;
	
	static ObservableList<StudentListTable> rows = FXCollections.observableArrayList();
	
	private String course_id;
	public void set(String course) {
		this.course_id = course;
		 System.out.println(this.course_id);
		 
		 studentDB sdb = new studentDB();

	        courseDB cdb = new courseDB();
	        String dep = cdb.getDepartment(course_id);
	        
	        ObservableList<StudentListTable> sts = sdb.getStudentBasedonDep(dep);
	        
	        System.out.println(course_id);
	        
	        enrollDB edb = new enrollDB();
	        
	        for(int i = 0; i < sts.toArray().length; i++) {
	        	StudentListTable newS = (StudentListTable) sts.toArray()[i];
	          sts.set(i, newS.setMarks1(edb.getMark(course_id, ((StudentListTable) sts.toArray()[0]).student_id)));		
	        }
			name_clm.setCellValueFactory(new PropertyValueFactory<>("name"));
			marks_clm.setCellValueFactory(new PropertyValueFactory<>("marks"));
			uid_clm.setCellValueFactory(new PropertyValueFactory<>("student_id"));
			rows = sts;
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
			            
			            AddMark ls1 = new AddMark();
			            ls1.show(rows.get(row.getIndex()).student_id, course_id, event);
			            System.out.println("done");
			        }
			    }
			});
			
	        
	}
	public void show(String course_id) {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("lecturer_student_list.fxml"));
            root = loader.load();
            LecturerStudentList lsl = loader.getController();
            lsl.set(course_id);
                       
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
