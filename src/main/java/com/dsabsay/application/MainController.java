package com.dsabsay.application;

import com.dsabsay.grader.SimpleRhythmGrader;
import com.dsabsay.model.UserConfiguration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
  private Stage primaryStage;
  private UserConfiguration userConfig;
  
  private Logger logger = Logger.getLogger("come.dsabsay.application.MainController");

  public MainController(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.userConfig = new UserConfiguration();
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

      PracticeController practiceCtrl = (PracticeController) fxmlLoader.getController();
      practiceCtrl.setMainController(this);
      throw new IOException();
    } catch (IOException exception) {
      // TODO Auto-generated catch block
      //exception.printStackTrace();
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
      
      SettingsController settingsCtrl = (SettingsController) fxmlLoader.getController();
      settingsCtrl.setMainController(this);
    } catch (IOException exception) {
      // TODO Auto-generated catch block
      //exception.printStackTrace();
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
      primaryStage.setTitle("SightSinger");

      // add reference to this MainController to the MainMenuController
      MainMenuController mainMenuCtrl = (MainMenuController) fxmlLoader.getController();
      mainMenuCtrl.setMainController(this);

      primaryStage.show();
    } catch (IOException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
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
