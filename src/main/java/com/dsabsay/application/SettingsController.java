package com.dsabsay.application;

import com.dsabsay.model.ControllerException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SettingsController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML
  private Button okButton; // Value injected by FXMLLoader
  @FXML
  private Button cancelButton;
  @FXML
  private Button rhythmsPathButton;
  @FXML
  private TextField rhythmsPathField;
    
  private Logger logger = Logger.getLogger("com.dsabsay.application.SettingsController");

  /**
   * Initializes the controller class.
   */
  @FXML // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    assert okButton != null && cancelButton != null && rhythmsPathButton != null
        && rhythmsPathField != null
        : "Something was not injected: check your FXML file 'Settings.fxml'.";

    //should check if the controls are null first, the above assert won't stop this from executing
    rhythmsPathButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        chooseRhythmsPath();
      }
    });
    
    okButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          MainController.getInstance().startMainMenu();
        } catch (ControllerException ex) {
          logger.log(Level.SEVERE, "Error loading main menu.", ex);
        }
      }
    });
    
    rhythmsPathField.textProperty().addListener(new ChangeListener<String>() {
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        try {
          MainController.getInstance().getUserConfiguration()
              .setRhythmsPath(rhythmsPathField.getText());
        } catch (ControllerException ex) {
          logger.log(Level.SEVERE, "Error setting rhythms path.", ex);
        }
      }
    });
    
    rhythmsPathField.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          MainController.getInstance().getUserConfiguration()
              .setRhythmsPath(rhythmsPathField.getText());
        } catch (ControllerException ex) {
          logger.log(Level.SEVERE, "Error setting rhythms path.", ex);
        }
      }
    });
    
    //set path field
    try {
      rhythmsPathField.setText(MainController.getInstance().getUserConfiguration()
          .getRhythmsPath());
    } catch (ControllerException ex) {
      logger.log(Level.SEVERE, "Error getting rhythms path.", ex);
    }
    
  }

  private void chooseRhythmsPath() {
    MainController mainController;
    try {
      mainController = MainController.getInstance();
    } catch (ControllerException ex) {
      logger.log(Level.SEVERE, "Error getting main controller.", ex);
      return;
    }
    
    DirectoryChooser directoryChooser = new DirectoryChooser();
    directoryChooser.setTitle("Select rhythms path");
    File directory = directoryChooser.showDialog(mainController.getStage());
    
    if (directory != null) {
      mainController.getUserConfiguration().setRhythmsPath(directory.getAbsolutePath());
      rhythmsPathField.setText(directory.getAbsolutePath());
    }
  }

}
