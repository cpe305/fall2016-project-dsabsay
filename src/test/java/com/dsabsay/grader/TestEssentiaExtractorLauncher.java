package com.dsabsay.grader;

public class TestEssentiaExtractorLauncher {
  public static void main(String[] args) {
    EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    
    launcher.processRhythmPerformance("tap_120bpm.m4a");
  }
}
