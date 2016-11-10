package com.dsabsay.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VexTabRhythmExercise extends VexTabExercise {

  private int rhythmId;
  private String rhythmType;
  private String pathToExercise;
  private RhythmExercise exercise;
  private String vextabNotation;

  /**
   * Creates a RhythmExercise object.
   * 
   * @param rhythmId
   *          rhythm id
   * @param rhythmType
   *          rhythm type
   * @param pathToExercise
   *          path to exercise on disk
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

    // read file
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
      this.vextabNotation = vextab;
      this.exercise = parser.parseVexTab(vextab);
    } catch (InvalidVexTabException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String getVextabNotation() {
    return vextabNotation;
  }

  //assumes only one line of notes
  public String getNotesString() {
    
    //get lines starting with "notes"
    String noteLine;
    int index = this.vextabNotation.indexOf("notes");
    int indexOfNewline = this.vextabNotation.substring(index).indexOf('\n');
    
    if (indexOfNewline == -1) {
      noteLine = this.vextabNotation.substring(index);
    } else {
      noteLine = this.vextabNotation.substring(index)
          .substring(0, this.vextabNotation.substring(index).indexOf('\n'));
    }
    
    return noteLine;
  }
  
  public String getTimeSig() throws InvalidVexTabException {
    // parse time signature
    int index = this.vextabNotation.indexOf("time=");
    if (index == -1) {
      throw new InvalidVexTabException();
    }
    
    System.out.println("timeSig: " + this.vextabNotation.substring(index + 5, index + 9));
    return this.vextabNotation.substring(index + 5, index + 9);
  }
  
}
