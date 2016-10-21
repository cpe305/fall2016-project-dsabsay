package com.dsabsay.application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	private Stage primaryStage;
	
	public MainController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void startPracticeView() {
        try {
			//create FXMLLoader
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Practice.fxml"));
			Scene scene = new Scene((AnchorPane) fxmlLoader.load());
			primaryStage.setScene(scene);

			PracticeController practiceCtrl = (PracticeController) fxmlLoader.getController();
			practiceCtrl.setMainController(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startMainMenu() {
		
		try {
			//AnchorPane mainMenu = (AnchorPane) fxmlLoader.load(Main.class.getResource("MainMenu.fxml"));
			
			//create FXMLLoader
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene((AnchorPane) fxmlLoader.load());
			primaryStage.setScene(scene);
			primaryStage.setTitle("SightSinger");
			
			//add reference to this MainController to the MainMenuController
			MainMenuController mainMenuCtrl = (MainMenuController) fxmlLoader.getController();
			mainMenuCtrl.setMainController(this);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
