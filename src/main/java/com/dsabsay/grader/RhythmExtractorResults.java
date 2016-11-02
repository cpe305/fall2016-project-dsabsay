package com.dsabsay.grader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RhythmExtractorResults {
  private float bpm;
  private List<Float> ticks;
  
  public RhythmExtractorResults(String string) {
    String[] lines = string.split("\\n|\\r");
    
    String bpmLine = lines[4];
    this.bpm = Float.parseFloat(bpmLine.split(":\\s+")[1]);
    
    System.out.println("bpm: " + this.bpm);
    
    String ticksLine = lines[5];
    this.ticks = new ArrayList<Float>();
    String ticksList = ticksLine.split("\\[|\\]")[1];
    List<String> ticksListString = Arrays.asList(ticksList.split(",\\s*+"));
    for (String s : ticksListString) {
      this.ticks.add(Float.parseFloat(s));
    }
    
    System.out.println("ticks: " + this.ticks);
  }
}
