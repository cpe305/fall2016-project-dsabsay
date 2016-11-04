package com.dsabsay.grader;

public class TestRhythmExtractorResults {
  public static void main(String[] args) {
    EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    
    System.out.println("Process rhythm performance: tap_120bpm.m4a");
    
    String string = launcher.processRhythmPerformance("tap_120bpm.m4a");
    
    System.out.println("---------------------");
    System.out.println("parse results:\n");
    RhythmExtractorResults results = new RhythmExtractorResults(string);
  }
}
