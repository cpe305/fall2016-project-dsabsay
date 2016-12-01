package com.dsabsay.application;

import com.dsabsay.grader.SimpleRhythmGrader;
import com.dsabsay.model.ControllerException;
import com.dsabsay.model.UserConfiguration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
  private static MainController instance = null;
  private Stage primaryStage;
  private UserConfiguration userConfig;
  
  private Logger logger = Logger.getLogger("com.dsabsay.application.MainController");

  private MainController(Stage primaryStage) {
    this.primaryStage = primaryStage;
    
    try {
      this.userConfig = new UserConfiguration();
    } catch (IOException ex) {
      logger.log(Level.SEVERE, "Error loading user configuration.", ex);
    }
    
    instance = this;
  }
  
  /**
   * Initializes the MainController. Should only be called once, when the application starts.
   * @param primaryStage the primary stage of the JavaFX application
   * @return the instantiated MainController object
   */
  public static MainController createInstance(Stage primaryStage) {
    instance = new MainController(primaryStage);
    
    return instance;
  }
  
  /**
   * Returns the instance of MainController for the application.
   * @return the instance of MainController for the application
   * @throws ControllerException if the MainController has not been instantiated
   */
  public static MainController getInstance() throws ControllerException {
    if (instance == null) {
      throw new ControllerException("The MainController has not been instantiated.");
    }
    
    return instance;
  }

  /**
   * Starts the practice view.
   * 
   */
  public void startRhythmPracticeView() {
    try {
      // create FXMLLoader
      FXMLLoader fxmlLoader
          = new FXMLLoader(getClass().getClassLoader().getResource("Practice.fxml"));
      fxmlLoader.setController(new PracticeController(this, new SimpleRhythmGrader()));
      Scene scene = new Scene((AnchorPane) fxmlLoader.load());
      primaryStage.setScene(scene);
    } catch (IOException exception) {
      logger.log(Level.SEVERE, "Error starting practice rhythm view.", exception);
    }
  }
  
  /**
   * Opens the settings page.
   */
  public void startSettings() {
    try {
      // create FXMLLoader
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader()
          .getResource("Settings.fxml"));
      //need to instantiate controller before calling fxmlLoader.load() because the controller needs
      //a reference to the main controller
      fxmlLoader.setController(new SettingsController(this));
      Scene scene = new Scene((AnchorPane) fxmlLoader.load());
      primaryStage.setScene(scene);
    } catch (IOException exception) {
      logger.log(Level.SEVERE, "Error loading settings page.", exception);
    }
  }

  /**
   * Starts the main menu view.
   */
  public void startMainMenu() {

    try {
      // AnchorPane mainMenu = (AnchorPane)
      // fxmlLoader.load(Main.class.getResource("MainMenu.fxml"));

      System.out.println("get resource: "
          + getClass().getClassLoader().getResource("MainMenu.fxml"));
      // create FXMLLoader
      FXMLLoader fxmlLoader
          = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
      Scene scene = new Scene((AnchorPane) fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.setTitle("RhythmTrainer");
      primaryStage.show();
    } catch (IOException exception) {
      logger.log(Level.SEVERE, "Error loading main menu.", exception);
    }

  }
  
  public Stage getStage() {
    return this.primaryStage;
  }
  
  public UserConfiguration getUserConfiguration() {
    return this.userConfig;
  }
}
