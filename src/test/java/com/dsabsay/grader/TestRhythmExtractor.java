package com.dsabsay.grader;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRhythmExtractor {

  @Test
  public void test() {
    String filename = "tap_quarterNotes.m4a";
    
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
    
    assertEquals(results.getBpm(), expected.getBpm(), .0000001);
    assertEquals(results.getTicks(), expected.getTicks());
    assertEquals(results.getOnsets(), expected.getOnsets());
  }

}
