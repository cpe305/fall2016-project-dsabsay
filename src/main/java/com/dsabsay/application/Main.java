package com.dsabsay.application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		MainController mainController = new MainController(primaryStage);
		mainController.startMainMenu();
	}
	

	
	public static void main(String[] args) {
		//launch(args);
        Application.launch(Main.class, (java.lang.String[])null);
	}
}
