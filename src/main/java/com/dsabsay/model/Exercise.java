package com.dsabsay.model;

public abstract class Exercise {
  private int id;
  private String type;
  protected String pathToExercise;
  private String name;
  
  public Exercise(int id, String type, String pathToExercise, String name) {
    this.id = id;
    this.type = type;
    this.pathToExercise = pathToExercise;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getPathToExercise() {
    return pathToExercise;
  }

  public String getName() {
    return name;
  }
}
