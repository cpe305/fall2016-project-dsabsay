package com.dsabsay.application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    MainController mainController = new MainController(primaryStage);
    mainController.startMainMenu();
  }

  public static void main(String[] args) {
    // launch(args);
    Application.launch(Main.class, (java.lang.String[]) null);
  }
}
