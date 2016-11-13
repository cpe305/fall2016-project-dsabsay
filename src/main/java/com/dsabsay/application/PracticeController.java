package com.dsabsay.application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.UserConfiguration;
import com.dsabsay.model.VexTabExercise;
import com.dsabsay.model.VexTabRhythmExercise;
import com.dsabsay.repo.VexTabExercisesRepo;
import com.dsabsay.repo.VexTabRhythmExercisesRepo;

public class PracticeController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML // fx:id="button"
  private Button recordButton; // Value injected by FXMLLoader
  @FXML
  private Button optionsButton;
  @FXML
  private WebView webView;
  @FXML
  private Label melodyTypeLabel;

  private MainController mainController;

  public PracticeController(MainController mainController) {
    this.mainController = mainController;
  }
  
  /**
   * Initializes the controller class.
   */
  @FXML // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    /*
     * assert sightSingButton != null :
     * "fx:id=\"sightSingButton\" was not injected: check your FXML file 'MainMenu.fxml'.";
     * 
     * if (sightSingButton != null) { sightSingButton.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event) {
     * System.out.println("Practice sight singing!"); } }); }
     */
    
    assert recordButton != null && optionsButton != null
        : "fx:id=\"recordButton\" was not injected: check your FXML file 'Practice.fxml'.";

    if (optionsButton != null) {
      optionsButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          mainController.startMainMenu();
        }
      });
    }
    
    NotationWebView notationWebView = new NotationWebView(webView);
    
    //String path = "src/main/resources/testRhythm2.txt";
    //VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    //UserConfiguration config = new UserConfiguration();
    //config.setRhythmsPath("src/main/exercises/rhythmExercises");
    VexTabExercisesRepo repo = null;
    
    try {
      repo = new VexTabRhythmExercisesRepo(mainController.getUserConfiguration());
    } catch (FileNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("No exercises found");
      alert.setHeaderText(null);
      alert.setContentText("No exercises were found. Make sure the path to your exercises is "
          + "set correctly.");
      alert.showAndWait();
    }
    
    VexTabExercise exercise = repo.getRandomExercise();
    
    try {
      notationWebView.displayExercise(exercise);
    } catch (InvalidVexTabException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    /*
    String options = "options font-size=14 space=15";
    String tabstave = "tabstave notation=true tablature=false time=4/4 clef=percussion";
    //String notes = "notes :2S Bd/4 :qS Bd/4 :q ## | :8S Bd/4 Bu/4 :qS Bd-Bu-Bd/4 ^3^";
    String notes = "notes :2S B/4 :qS B/4 :q ## | :8S B/4 B/4 :qS B-B-B/4 ^3^";
    //String notes = "notes :1S B/4 :qS B/4 :q ## | :8S B/4 B/4 :qS B-B-B/4 ^3^";
    String notation = "\n options font-size=14 space=15"
        + "\n tabstave notation=true tablature=false"
        + "\n time=4/4 clef=percussion "
        + "\n notes :2S Bd/4 :qS Bd/4 :q ## | :8S Bd/4 Bu/4 :qS Bd-Bu-Bd/4 ^3^ "
        + "\n text :w, G Maj7, |, Am " + "\n options space=10\n";

    System.out.println("notation: " + notation);
    System.out.println("notationWebView:" + notationWebView);
    WebEngine webEngine = notationWebView.getEngine();
    ClassLoader classLoader = this.getClass().getClassLoader();
    String url = classLoader.getResource("notation.html").toExternalForm();
    // String url = Main.class.getResource("/src/main/VexFlow/notation.html").toExternalForm();
    notationWebView.setZoom(0.75);
    // need to set appropriate zoom
    // get size of div, compare with size of webview, then scale appropriately
    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
      public void changed(ObservableValue ov, State oldState, State newState) {
        if (newState == State.SUCCEEDED) {
          // webEngine.executeScript("notate()");
          // webEngine.executeScript("notate('" + notation + "')");
          webEngine.executeScript("notateVexTab('" + notes + "')");
        }
      }
    });
    webEngine.load(url);
    */

    /*
    webEngine
      .load("/Users/danielsabsay/Documents/workspace/javafxtest/src/application/notation.html");
    */
  }

  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }

}
