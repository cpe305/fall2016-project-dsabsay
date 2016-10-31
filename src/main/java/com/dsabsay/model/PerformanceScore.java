package com.dsabsay.model;

import java.util.List;

public abstract class PerformanceScore {
  private float score;
  private List<String> comments;
  
  public PerformanceScore(float score, List<String> comments) {
    this.score = score;
    this.comments = comments;
  }
}
