package com.dsabsay.application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML // fx:id="button"
  private Button okButton; // Value injected by FXMLLoader
  @FXML
  private Button cancelButton;
  @FXML
  private Button rhythmsPathButton;
  @FXML
  private TextField rhythmsPathField;
  
  private MainController mainController;
  
  public SettingsController(MainController mainController) {
    this.mainController = mainController;
  }

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
        if (mainController == null) {
          System.out.println("mainController not set in MainMenuController!");
          System.exit(1);
        }
        chooseRhythmsPath();
      }
    });
    
    okButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if (mainController == null) {
          System.out.println("mainController not set in MainMenuController!");
          System.exit(1);
        }
        mainController.startMainMenu();
      }
    });
    
    rhythmsPathField.textProperty().addListener(new ChangeListener<String>() {
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (mainController == null) {
          System.out.println("mainController not set in MainMenuController!");
          System.exit(1);
        }
        mainController.getUserConfiguration().setRhythmsPath(rhythmsPathField.getText());
      }
    });
    
    rhythmsPathField.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if (mainController == null) {
          System.out.println("mainController not set in MainMenuController!");
          System.exit(1);
        }
        mainController.getUserConfiguration().setRhythmsPath(rhythmsPathField.getText());
      }
    });
    
    //set path field
    rhythmsPathField.setText(this.mainController.getUserConfiguration().getRhythmsPath());
    
  }

  private void chooseRhythmsPath() {
    DirectoryChooser directoryChooser = new DirectoryChooser();
    directoryChooser.setTitle("Select rhythms path");
    File directory = directoryChooser.showDialog(mainController.getStage());
    
    if (directory != null) {
      mainController.getUserConfiguration().setRhythmsPath(directory.getAbsolutePath());
      rhythmsPathField.setText(directory.getAbsolutePath());
    }
  }
  
  /** 
   * Sets the main controller for this MainMenuController.
   * 
   * @param mainController the mainController
   */
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
    System.out.println("setMainController");
    System.out.println("mainController:" + this.mainController);
  }

}
