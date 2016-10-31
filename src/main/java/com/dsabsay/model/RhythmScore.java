package com.dsabsay.model;

import java.util.List;

public class RhythmScore
    extends PerformanceScore {
  
  /**
   * Creates a RhythmScore object.
   * @param score the score
   * @param comments comments on performance
   */
  public RhythmScore(float score, List<String> comments) {
    super(score, comments);
  }
}
