package com.dsabsay.grader;

import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.VexTabExercise;

public interface PerformanceGrader {
  /*
  public PerformanceScore evaluatePerformance(VexTabExercise exercise, ExtractorResults results,
      float rhythmErrorMargin);
  */
  
  public PerformanceScore evaluatePerformance(VexTabExercise exercise, String performanceFilename,
      float rhythmErrorMargin) throws ExtractorException;
}
