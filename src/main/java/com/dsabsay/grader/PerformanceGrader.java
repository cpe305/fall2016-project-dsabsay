package com.dsabsay.grader;

import com.dsabsay.model.Exercise;
import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.VexTabExerciseAbstractClass;

public interface PerformanceGrader {
  /*
  public PerformanceScore evaluatePerformance(VexTabExercise exercise, ExtractorResults results,
      float rhythmErrorMargin);
  */
  
  /*
  public PerformanceScore evaluatePerformance(VexTabExerciseAbstractClass exercise,
    String performanceFilename, float rhythmErrorMargin) throws ExtractorException;
  */
  public PerformanceScore evaluatePerformance(Exercise exercise, String performanceFilename,
      float rhythmErrorMargin) throws ExtractorException, GraderException;
}
