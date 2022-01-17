package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.*;

public class SuccessScreen {
	@FXML
	private Label message;
	
	public void setMessage(String successMessage) {
		message.setText(successMessage);
	}
	
	public void show(String successMessage) {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("success.fxml"));
	            root = loader.load();
	            
	            SuccessScreen successScreen = loader.getController();
	            successScreen.setMessage(successMessage);
	           
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root, 608, 226));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	@FXML
	private void onClose(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
}
