package com.dsabsay.grader;

public class TestRhythmExtractorResults {
  public static void main(String[] args) {
    EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    
    String string = launcher.processRhythmPerformance("tap_120bpm.m4a");
    
    RhythmExtractorResults results = new RhythmExtractorResults(string);
  }
}
