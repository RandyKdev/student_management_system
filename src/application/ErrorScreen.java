package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.*;

public class ErrorScreen {
	@FXML
	private Label title;
	@FXML
	private Label subTitle;
	
	public void setTitle(String errorTitle) {
		title.setText(errorTitle);
	}
	
	public void setSubtitle(String errorSubtitle) {
		subTitle.setText(errorSubtitle);
	}
	
	public void show(String errorTitle, String errorSubtitle) {
		 Parent root;
	        try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("error.fxml"));
	            root = loader.load();
	            
	            ErrorScreen errorScreen = loader.getController();
	            errorScreen.setTitle(errorTitle);
	            if(errorSubtitle == null || errorSubtitle.isEmpty()) errorScreen.setSubtitle("");
	            else errorScreen.setSubtitle(errorSubtitle);
	           
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root, 640, 285));
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
