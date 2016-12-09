package com.dsabsay.application;

import com.dsabsay.model.ControllerException;
import com.dsabsay.model.Progress;
import com.dsabsay.repo.PerformanceRecordRepo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressController {
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  @FXML
  private Button okButton; // Value injected by FXMLLoader
  @FXML
  private ListView<String> statsList;
    
  private Logger logger = Logger.getLogger("com.dsabsay.application.ProgressController");

  /**
   * Initializes the controller class.
   */
  @FXML // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    assert okButton != null && statsList != null
        : "Something was not injected: check your FXML file 'ProgressView.fxml'.";
    
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
    
    PerformanceRecordRepo recordRepo = null;
    
    try {
      recordRepo = MainController.getInstance().getRecordRepo();
    } catch (ControllerException ex) {
      logger.log(Level.SEVERE, "Error accessing record repo.", ex);
      return;
    }
    
    Progress progress = new Progress();
    ObservableList<String> list = FXCollections.observableArrayList();
    System.out.println("ProgressController: recordRepo: " + recordRepo);
    list.addAll(progress.getDefaultStatsForRhythm(recordRepo));

    // set up listview
    statsList.setEditable(true);
    statsList.setItems(list);
    //statsList.setCellFactory(ComboBoxListCell.forListView(items));
    
  }

}
