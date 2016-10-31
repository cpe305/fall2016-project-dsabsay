package com.dsabsay.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
  private Stage primaryStage;

  public MainController(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Starts the practice view.
   * 
   */
  public void startPracticeView() {
    try {
      // create FXMLLoader
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Practice.fxml"));
      Scene scene = new Scene((AnchorPane) fxmlLoader.load());
      primaryStage.setScene(scene);

      PracticeController practiceCtrl = (PracticeController) fxmlLoader.getController();
      practiceCtrl.setMainController(this);
    } catch (IOException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
  }

  /**
   * Starts the main menu view.
   */
  public void startMainMenu() {

    try {
      // AnchorPane mainMenu = (AnchorPane)
      // fxmlLoader.load(Main.class.getResource("MainMenu.fxml"));

      // create FXMLLoader
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
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
    }

  }
}
