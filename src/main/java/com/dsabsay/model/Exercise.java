package com.dsabsay.model;

public abstract class Exercise {
  private int id;
  private String type;
  protected String pathToExercise;
  private String name;
  
  /**
   * Create an Exercise object.
   * @param id exercise ID
   * @param type exercise type
   * @param pathToExercise path to the exercise file on the disk
   * @param name name of the exercise
   */
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
