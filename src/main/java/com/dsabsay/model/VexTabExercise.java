package com.dsabsay.model;

public interface VexTabExercise {
  public abstract String getVexTabNotation();
  
  public abstract String getTimeSig() throws InvalidVexTabException;
  
  public abstract String getNotesString();
}
