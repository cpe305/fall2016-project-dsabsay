package com.dsabsay.grader;

import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.VexTabRhythmExercise;

public class SimpleRhythmGraderTester {
  //errorMargin (in beats)
  private static final float errorMargin = (float) 0.20;
  
  /**
   * Tester for SimpleRhythmGrader.
   * @param args args
   * @throws ExtractorException exception
   */
  public static void main(String[] args) throws ExtractorException {
    testGrader("src/main/resources/testRhythmQuarterNotes.txt", "tap_quarterNotes.m4a");
    testGrader("src/main/resources/testRhythmQuarterNotes.txt", "tap_quarterNotes_mistake.m4a");
    testGrader("src/main/resources/testRhythmQuarterNotes.txt", "tap_quarterNotes_mistake2.m4a");
    testGrader("src/main/resources/testRhythmQuarterNotes.txt", "tap_quarterNotes_speedup.m4a");
    testGrader("src/main/resources/testRhythm2.txt", "testRhythm2.m4a");
    testGrader("src/main/resources/testRhythmEighthNotes.txt", "testRhythmEighthNotes.m4a");
  }
  
  private static void testGrader(String exercisePath, String performancePath)
      throws ExtractorException {
    System.out.println("Grading performance: " + performancePath + " for " + exercisePath);
    
    //String path = "src/main/resources/testRhythmQuarterNotes.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", exercisePath);
    
    RhythmExtractor extractor = new RhythmExtractor();
    RhythmExtractorResults results = extractor.processPerformance(performancePath);
    //EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    //String string = launcher.processRhythmPerformance("tap_120bpm.m4a");
    //String string = launcher.processRhythmPerformance(performancePath);
    //RhythmExtractorResults results = new RhythmExtractorResults(string);
    
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
