package com.dsabsay.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VexTabRhythmExercise 
    extends VexTabExercise {
  
  private int rhythmId;
  private String rhythmType;
  private String pathToExercise;
  private RhythmExercise exercise;
  
  /**
   * Creates a RhythmExercise object.
   * @param rhythmId rhythm id
   * @param rhythmType rhythm type
   * @param pathToExercise path to exercise on disk
   */
  public VexTabRhythmExercise(int rhythmId, String rhythmType, String pathToExercise) {
    this.rhythmId = rhythmId;
    this.rhythmType = rhythmType;
    this.pathToExercise = pathToExercise;
    read();
  }
  
  public String getVexTabNotation() {
    return "";
  }
  
  public RhythmExercise getExercise() {
    return exercise;
  }
  
  private void read() {
    VexTabRhythmParser parser = new VexTabRhythmParser();
    
    //read file
    File file = new File(pathToExercise);
    BufferedReader reader = null;
    String vextab = "";
    String buffer = null;
    
    try {
      reader = new BufferedReader(new FileReader(file));
      
      while ((buffer = reader.readLine()) != null) {
        vextab += buffer;
      }
      
      reader.close();
      
      System.out.println("Read file");
      System.out.println(vextab);
      
    } catch (FileNotFoundException exception) {
      exception.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    
    try {
      this.exercise = parser.parseVexTab(vextab);
    } catch (InvalidVexTabException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
}
