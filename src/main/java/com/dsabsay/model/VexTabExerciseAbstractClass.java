package com.dsabsay.model;

public abstract class VexTabExerciseAbstractClass extends Exercise {
    
  public abstract String getVexTabNotation();
  
  public abstract String getTimeSig() throws InvalidVexTabException;
  
  public abstract String getNotesString();
  
  public VexTabExerciseAbstractClass(int id, String type, String pathToExercise, String name) {
    super(id, type, pathToExercise, name);
  }
}
