package com.dsabsay.model;

public abstract class VexTabExercise {
  public abstract String getVexTabNotation();
  public abstract String getTimeSig() throws InvalidVexTabException;
  public abstract String getNotesString();
}
