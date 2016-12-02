package com.dsabsay.application;

import com.dsabsay.model.ControllerException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenuController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML // fx:id="button"
  private Button rhythmButton; // Value injected by FXMLLoader
  @FXML
  private Button settingsButton;
  @FXML
  private Button viewProgressButton;
    
  private Logger logger = Logger.getLogger("com.dsabsay.application.MainMenuController");

  /**
   * Initializes the controller class.
   */
  @FXML // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    assert rhythmButton != null
        : "fx:id=\"sightSingButton\" was not injected: check your FXML file 'MainMenu.fxml'.";

    if (settingsButton != null) {
      settingsButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          /*
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          mainController.startSettings();
          */
          
          try {
            MainController.getInstance().startSettings();
          } catch (ControllerException ex) {
            logger.log(Level.SEVERE, "Error loading settings page.", ex);
          }
        }
      });
    }
    
    if (rhythmButton != null) {
      rhythmButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          System.out.println("Practice sight singing!");
          /*
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          mainController.startRhythmPracticeView();
          */
          try {
            MainController.getInstance().startRhythmPracticeView();
          } catch (ControllerException ex) {
            logger.log(Level.SEVERE, "Error starting practice view.", ex);
          }
        }
      });
    }
    
    if (viewProgressButton != null) {
      viewProgressButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          try {
            MainController.getInstance().startProgressView();
          } catch (ControllerException ex) {
            logger.log(Level.SEVERE, "Error loading progress view.", ex);
          }
        }
      });
    }
  }

}
