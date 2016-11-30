package com.dsabsay.grader;

import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.RhythmScore;

import java.util.ArrayList;

public abstract class RhythmGrader 
    implements PerformanceGrader {

  public RhythmGrader() {
    
  }
  
  public PerformanceScore evaluatePerformance() {
    return new RhythmScore(1, new ArrayList<String>());
  }
}
