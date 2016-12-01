package com.dsabsay.application;

import com.dsabsay.grader.PerformanceGrader;
import com.dsabsay.model.ControllerException;
import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.Recorder;
import com.dsabsay.model.RecorderException;
import com.dsabsay.model.VexTabExercise;
import com.dsabsay.repo.VexTabExercisesRepo;
import com.dsabsay.repo.VexTabRhythmExercisesRepo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.LineUnavailableException;

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
  @FXML
  private ProgressIndicator progressIndicator;
  @FXML
  private Label scoreLabel;
  @FXML
  private Circle recordCircle;

  private Recorder recorder;
  private VexTabExercise currentExercise;
  private PerformanceGrader grader;
  
  private Logger logger = Logger.getLogger("com.dsabsay.application.PracticeController");

  public PracticeController(MainController mainController, PerformanceGrader grader) {
    //this.mainController = mainController;
    this.grader = grader;
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
    
    this.recorder = new Recorder();
    
    assert recordButton != null && optionsButton != null
        : "fx:id=\"recordButton\" was not injected: check your FXML file 'Practice.fxml'.";

    if (optionsButton != null) {
      optionsButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          /*
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          mainController.startMainMenu();
          */
          
          try {
            MainController.getInstance().startMainMenu();
          } catch (ControllerException ex) {
            logger.log(Level.SEVERE, "Error loading main menu.", ex);
          }
        }
      });
    }
    
    if (recordButton != null) {
      recordButton.getStylesheets().add(getClass().getClassLoader()
          .getResource("practiceController.css").toExternalForm());
      
      recordButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          /*
          if (mainController == null) {
            System.out.println("mainController not set in MainMenuController!");
            System.exit(1);
          }
          */
          
          if (!recorder.isRecording()) {
            startRecording();
          } else {
            stopRecording();
          }
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
      repo = new VexTabRhythmExercisesRepo(MainController.getInstance().getUserConfiguration());
    } catch (ControllerException | IOException | InvalidVexTabException ex) {
      logger.log(Level.SEVERE, "Error initializing VexTabRhythmExercisesRepo.", ex);
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("No exercises found");
      alert.setHeaderText(null);
      alert.setContentText("No exercises were found. Make sure the path to your exercises is "
          + "set correctly.");
      alert.showAndWait();
      return;
    }
    
    this.currentExercise = repo.getRandomExercise();
    
    try {
      notationWebView.displayExercise(this.currentExercise);
      //change label
    } catch (InvalidVexTabException exception) {
      logger.log(Level.SEVERE, "Error displaying exercise.", exception);
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
  
  private void startRecording() {
    try {
      recorder.startRecording();
      //recordButton.setStyle("-fx-background-color: #ff0000");
      recordButton.getStyleClass().add("recording");
      //recordButton.
      System.out.println("recordButton styleClasses: " + recordButton.getStyleClass());
      System.out.println("recordButton styleSheets: " + recordButton.getStylesheets());
    } catch (IOException | LineUnavailableException | RecorderException ex) {
      logger.log(Level.SEVERE, "Error starting recording.", ex);
      showAlertAndWait("Recorder Error", "An error occured trying to record audio.");
    }
  }

  private void stopRecording() {
    progressIndicator.setVisible(true);
    String performanceFilename = null;
    try {
      performanceFilename = recorder.stopRecording();
    } catch (RecorderException ex) {
      logger.log(Level.SEVERE, "Error stopping recording.", ex);
      showAlertAndWait("Throwable thrown", "An error occured in the recording thread.");
    }
    
    //recordButton.setStyle(null);
    recordButton.getStyleClass().remove("recording");
    
    PerformanceScore score = null;
    try {
      score = grader.evaluatePerformance(currentExercise, performanceFilename,
          (float) 0.20);
    } catch (ExtractorException ex) {
      logger.log(Level.SEVERE, "Error evaluating performance.", ex);
      showAlertAndWait("ExtractorExcpetion",
          "An error occured while evaluating the performance.");
      return;
    }
    
    progressIndicator.setVisible(false);
    scoreLabel.setText(score.getScore() * 100 + "%");
    scoreLabel.setVisible(true);
  }
  
  private void showAlertAndWait(String title, String content) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
  }
  
  /*
  private void gradePerformance(String filename) {
    //errorMargin (in beats)
    final float errorMargin = (float) 0.20;
    
    RhythmExtractor extractor = new RhythmExtractor();
    RhythmExtractorResults results;
    
    try {
      results = extractor.processPerformance(filename);
    } catch (ExtractorException ex) {
      // TODO Auto-generated catch block
      ex.printStackTrace();
      showAlertAndWait("Extractor Exception", "An error occured while processing the performance.");
    }
    
    SimpleRhythmGrader grader = new SimpleRhythmGrader();
    PerformanceScore score = grader.evaluatePerformanceSimpler(this.currentExercise,
        results, errorMargin);
  }
  */
  
  @FXML
  private void recordCircleMouseEntered() {
    recordCircle.setFill(Paint.valueOf("#cc7c7c"));
  }
  
  @FXML
  private void recordCircleMouseExited() {
    recordCircle.setFill(Paint.valueOf("#f8b4b4"));
  }
  
  @FXML
  private void recordCircleMouseClicked() {
    if (!recorder.isRecording()) {
      recordCircle.setFill(Paint.valueOf("#ff6464"));
      DropShadow dropShadow = new DropShadow();
      dropShadow.setWidth(70);
      dropShadow.setWidth(70);
      dropShadow.setRadius(35);
      dropShadow.setColor(Color.valueOf("#d31414"));
      
      recordCircle.setEffect(dropShadow);
      recordCircle.setFill(Paint.valueOf("#d31414"));
      
      startRecording();
    } else {
      recordCircle.setEffect(null);
      recordCircle.setFill(Paint.valueOf("#f8b4b4"));
      
      stopRecording();
    }
    
  }

}
