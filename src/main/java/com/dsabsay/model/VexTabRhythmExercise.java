package com.dsabsay.model;

public class VexTabRhythmExercise 
    extends VexTabExercise {
  private int rhythmId;
  private String rhythmType;
  private String pathToExercise;
  
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
  }
  
  public String getVexTabNotation() {
    return "";
  }
}
