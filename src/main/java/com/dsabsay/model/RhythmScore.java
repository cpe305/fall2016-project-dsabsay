package com.dsabsay.model;

import java.util.Date;
import java.util.List;

public class RhythmScore extends PerformanceScore {
  
  /**
   * Creates a RhythmScore object.
   * @param score the score
   * @param comments comments on performance
   */
  public RhythmScore(float score, List<String> comments, Exercise exercise) {
    super(score, comments, exercise);
  }
  
  /**
   * Create a PerformanceRecord from the given PerformanceScore.
   * @return the PerformanceRecord
   */
  public PerformanceRecord createPerformanceRecord() {
    RhythmRecord record = new RhythmRecord(this.getExercise().getId(), this.getExercise().getType(),
        this.getExercise().getName(), this.getScore(), this.getScore(),
        new Date(), 0);
    
    return (PerformanceRecord) record;
  }

}
