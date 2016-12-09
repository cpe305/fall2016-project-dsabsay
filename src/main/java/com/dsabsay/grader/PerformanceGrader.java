package com.dsabsay.grader;

import com.dsabsay.model.Exercise;
import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.PerformanceScore;

public interface PerformanceGrader {
  public PerformanceScore evaluatePerformance(Exercise exercise, String performanceFilename,
      float rhythmErrorMargin) throws ExtractorException, GraderException;
}
