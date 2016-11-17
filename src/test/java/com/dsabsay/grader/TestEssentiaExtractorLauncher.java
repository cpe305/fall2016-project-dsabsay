package com.dsabsay.grader;

import java.io.File;
import java.nio.file.Files;

public class TestEssentiaExtractorLauncher {
  public static void main(String[] args) {
    //EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    
    //launcher.processRhythmPerformance("tap_120bpm.m4a");
    
    String filename = "tap_quarterNotes.m4a";
    
    File file = new File("essentia/" + filename);
    System.out.println("File: " + file.getAbsolutePath());
    System.out.println("  can read: " + Files.isReadable(file.toPath()));
    
    
    File executable
      = new File("essentia/essentia-extractors/essentia-extractors/essentia_standard_onsetrate");
    System.out.println("Executable: " + executable.getAbsolutePath());
    System.out.println("  can execute: " + Files.isExecutable(executable.toPath()));
  }
}
