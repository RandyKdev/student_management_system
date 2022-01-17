package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentNotAdmitted {
	@FXML
	private void onLogout(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
		LoginLogic ll = new LoginLogic();
		ll.show();
	}
	public void show() {
		Parent root;
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("student_not_admitted.fxml"));
            root = loader.load();
            
            loader.getController();
                       
            Stage stage = new Stage();
            stage.setScene(new Scene(root,  640, 285));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
