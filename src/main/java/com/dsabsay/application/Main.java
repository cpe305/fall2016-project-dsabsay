package com.dsabsay.application;

import java.io.IOException;

import com.dsabsay.model.UserConfiguration;
import com.dsabsay.repo.DefaultPerformanceRecordRepo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    /*
    MainController mainController = new MainController(primaryStage);
    mainController.startMainMenu();
    */
    
    UserConfiguration userConfig = null;
    try {
      userConfig = new UserConfiguration();
    } catch (IOException ex) {
      // TODO Auto-generated catch block
      ex.printStackTrace();
    }
    
    try {
      MainController.createInstance(primaryStage,
          new DefaultPerformanceRecordRepo(userConfig)).startMainMenu();
    } catch (ClassNotFoundException | IOException ex) {
      // TODO Auto-generated catch block
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // launch(args);
    Application.launch(Main.class, (java.lang.String[]) null);
  }
}
