package com.dsabsay.grader;

import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.VexTabRhythmExercise;

public class SimpleRhythmGraderTester {
  //errorMargin (in beats)
  private static final float errorMargin = (float) 0.14;
  
  public static void main(String[] args) {
    testGrader("src/main/resources/testRhythmQuarterNotes.txt", "tap_120bpm.m4a");
    testGrader("src/main/resources/testRhythm2.txt", "testRhythm2.m4a");
    testGrader("src/main/resources/testRhythmEighthNotes.txt", "testRhythmEighthNotes.m4a");
  }
  
  private static void testGrader(String exercisePath, String performancePath) {
    System.out.println("Grading performance: " + performancePath + " for " + exercisePath);
    
    //String path = "src/main/resources/testRhythmQuarterNotes.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", exercisePath);
    
    EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    //String string = launcher.processRhythmPerformance("tap_120bpm.m4a");
    String string = launcher.processRhythmPerformance(performancePath);
    RhythmExtractorResults results = new RhythmExtractorResults(string);
    
    SimpleRhythmGrader grader = new SimpleRhythmGrader();
    
    PerformanceScore score = grader.evaluatePerformanceSimpler(exercise, results, errorMargin);
    
    System.out.println("Graded Performance:");
    System.out.println("  Score: " + score.getScore() * 100 + "%");
    System.out.print("  Comments: ");
    
    for (String s : score.getComments()) {
      System.out.print(s);
    }
    
    System.out.println("\n");
  }
}
