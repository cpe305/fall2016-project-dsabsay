package com.dsabsay.application;

import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.VexTabExercise;
import com.dsabsay.model.VexTabExerciseAbstractClass;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NotationWebView extends Region {
  private WebView webView;
  private WebEngine webEngine;

  /**
   * Creates a NotationWebView object.
   */
  public NotationWebView() {
    webView = new WebView();
    webEngine = new WebEngine();
    webEngine.load("notation.html");
  }
  
  public NotationWebView(WebView webView) {
    this.webView = webView;
    this.webEngine = webView.getEngine();
  }
  
  /**
   * Displays exercise in the WebView.
   * @param exercise  the exercise to display
   * @throws InvalidVexTabException If VexTab notation for the exercise is invalid.
   */
  public void displayExercise(VexTabExercise exercise) throws InvalidVexTabException {
    String timeSig = exercise.getTimeSig();
    String notes = exercise.getNotesString();
    
    ClassLoader classLoader = this.getClass().getClassLoader();
    String url = classLoader.getResource("notation.html").toExternalForm();
    
    this.webView.setZoom(0.75);
    // need to set appropriate zoom
    // get size of div, compare with size of webview, then scale appropriately
    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
      public void changed(ObservableValue ov, State oldState, State newState) {
        if (newState == State.SUCCEEDED) {
          webEngine.executeScript("setTimeSig('" + timeSig + "')");
          webEngine.executeScript("notateVexTab('" + notes + "')");
        }
      }
    });
    webEngine.load(url);
    
  }
}
