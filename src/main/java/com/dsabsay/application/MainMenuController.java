package com.dsabsay.application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML // fx:id="button"
  private Button rhythmButton; // Value injected by FXMLLoader
  private MainController mainController;

  /**
   * Initializes the controller class.
   */
  @FXML // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    assert rhythmButton != null
        : "fx:id=\"sightSingButton\" was not injected: check your FXML file 'MainMenu.fxml'.";

    if (rhythmButton != null) {
      rhythmButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          System.out.println("Practice sight singing!");
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          mainController.startPracticeView();
        }
      });
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
