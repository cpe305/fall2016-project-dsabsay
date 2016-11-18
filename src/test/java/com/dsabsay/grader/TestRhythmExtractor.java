package com.dsabsay.grader;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dsabsay.model.ExtractorException;

public class TestRhythmExtractor {

  @Test
  public void test() throws ExtractorException {
    String filename = "tap_quarterNotes.m4a";
    
    File file = new File("essentia/" + filename);
    System.out.println("File: " + file.getAbsolutePath());
    System.out.println("  can read: " + Files.isReadable(file.toPath()));
    
    
    File executable
      = new File("essentia/essentia-extractors/essentia-extractors/essentia_standard_onsetrate");
    System.out.println("Executable: " + executable.getAbsolutePath());
    System.out.println("  can execute: " + Files.isExecutable(executable.toPath()));
    
    RhythmExtractor extractor = new RhythmExtractor();
    RhythmExtractorResults results = extractor.processPerformance(filename);
    
    RhythmExtractorResults expected = new RhythmExtractorResults();
    expected.setBpm((float) 104.414);
    
    List<Float> ticks = new ArrayList<Float>();
    ticks.add((float) 0.487619);
    ticks.add((float) 1.01007);
    ticks.add((float) 1.57896);
    ticks.add((float) 2.14785);
    ticks.add((float) 2.71673);
    ticks.add((float) 3.29723);
    ticks.add((float) 3.87773);
    ticks.add((float) 4.45823);
    expected.setTicks(ticks);
    
    List<Float> onsets = new ArrayList<Float>();
    onsets.add((float) 0.394739);
    onsets.add((float) 0.963628);
    onsets.add((float) 1.56735);
    onsets.add((float) 2.14785);
    onsets.add((float) 2.70512);
    onsets.add((float) 3.27401);
    onsets.add((float) 3.86612);
    onsets.add((float) 4.45823);
    expected.setOnsets(onsets);
    
    assertEquals(results.getBpm(), expected.getBpm(), .0001);
    assertEquals(results.getTicks(), expected.getTicks());
    assertEquals(results.getOnsets(), expected.getOnsets());
  }

}
