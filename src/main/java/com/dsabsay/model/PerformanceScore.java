package com.dsabsay.model;

import java.util.List;

public abstract class PerformanceScore {
  private float score;
  private List<String> comments;
  private Exercise exercise;
  
  public abstract PerformanceRecord createPerformanceRecord();
  
  /**
   * Constructor for PerformanceScore.
   * @param score score
   * @param comments comments
   * @param exercise exercise the score is calculated for
   */
  public PerformanceScore(float score, List<String> comments, Exercise exercise) {
    this.score = score;
    this.comments = comments;
    this.exercise = exercise;
  }

  public float getScore() {
    return score;
  }

  public List<String> getComments() {
    return comments;
  }
  
  public Exercise getExercise() {
    return exercise;
  }
}
