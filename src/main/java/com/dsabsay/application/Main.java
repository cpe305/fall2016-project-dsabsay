package com.dsabsay.application;

import com.dsabsay.model.UserConfiguration;
import com.dsabsay.repo.DefaultPerformanceRecordRepo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
  
  //maybe see if a static method can be used to avoid instantiating a logger in each class
  //that needs it?
  private Logger logger = Logger.getLogger("com.dsabsay.application.MainController");

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
      logger.log(Level.SEVERE, "Error loading user configuration.", ex);
    }
    
    try {
      MainController.createInstance(primaryStage,
          new DefaultPerformanceRecordRepo(userConfig)).startMainMenu();
    } catch (ClassNotFoundException | IOException ex) {
      logger.log(Level.SEVERE, "Error creating main controller.", ex);
    }
  }

  public static void main(String[] args) {
    // launch(args);
    Application.launch(Main.class, (java.lang.String[]) null);
  }
}
