package com.dsabsay.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class VexTabRhythmExercise extends Exercise implements VexTabExercise {
  private RhythmExercise exercise;
  private String vextabNotation;

  /**
   * Creates a VexTabRhythmExercise object.
   * @param rhythmId rhythm id
   * @param rhythmType rhythm type
   * @param pathToExercise path to exercise on disk
   * @throws FileNotFoundException if exercise file is not found
   * @throws IOException if IO error occurs
   * @throws InvalidVexTabException if the VexTab is invalid
   */
  public VexTabRhythmExercise(int rhythmId, String rhythmType, String pathToExercise)
      throws FileNotFoundException, IOException, InvalidVexTabException {
    super(rhythmId, rhythmType, pathToExercise, pathToExercise);
    read();
  }
  
  /**
   * Creates a VexTabRhythmExercise object.
   * @param rhythmId rhythmId
   * @param rhythmType rhythmType
   * @param pathToExercise pathToExercise
   * @param name name of exercise
   * @throws FileNotFoundException if exercise file is not found
   * @throws IOException if IO error occurs
   * @throws InvalidVexTabException if the VexTab is invalid
   */
  public VexTabRhythmExercise(int rhythmId, String rhythmType, String pathToExercise, String name)
      throws FileNotFoundException, IOException, InvalidVexTabException {
    super(rhythmId, rhythmType, pathToExercise, pathToExercise);
    read();
  }

  public String getVexTabNotation() {
    return "";
  }

  public RhythmExercise getExercise() {
    return exercise;
  }

  private void read() throws FileNotFoundException, IOException, InvalidVexTabException {

    // read file
    File file = new File(pathToExercise);
    BufferedReader reader = null;
    String vextab = "";
    String buffer = null;

    /*
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
    */
    
    reader = new BufferedReader(new FileReader(file));

    while ((buffer = reader.readLine()) != null) {
      vextab += buffer;
    }

    reader.close();

    System.out.println("Read file");
    System.out.println(vextab);

    /*
    try {
      this.vextabNotation = vextab;
      this.exercise = parser.parseVexTab(vextab);
    } catch (InvalidVexTabException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
    */
    
    this.vextabNotation = vextab;
    VexTabRhythmParser parser = new VexTabRhythmParser();
    this.exercise = parser.parseVexTab(vextab);
    
  }

  public String getVextabNotation() {
    return vextabNotation;
  }

  //assumes only one line of notes
  /**
   * Returns the line in the VexTab notation that contains the notes of the exercise.
   * Assumes that there is only one line of notes in the VexTab notation.
   */
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
  
  /**
   * Returns the time signature of the VexTab notation.
   * This code may already be in VexTabRhythmParser.
   * @throws InvalidVexTabException if no time signature is found in the VexTab notation
   */
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
