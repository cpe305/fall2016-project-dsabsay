package com.dsabsay.grader;

import com.dsabsay.model.ExtractorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RhythmExtractor {
  private RhythmExtractorResults results;
  
  public RhythmExtractor() {
    this.results = new RhythmExtractorResults();
  }
  
  /**
   * Launches the Essentia extractors to process the performance.
   * @param filename filename of the performance audio file
   * @return RhythmExtractorResults
   * @throws ExtractorException if an error occurs with the extractor(s)
   */
  public RhythmExtractorResults processPerformance(String filename) throws ExtractorException {
    //EssentiaExtractorLauncher launcher = new EssentiaExtractorLauncher();
    
    //try to use python extractors
    EssentiaExtractorLauncher launcher = new PythonEssentiaExtractorLauncher();
    
    String rhythmExtractorOutput = launcher.runRhythmExtractor(filename);
    String onsetExtractorOutput = launcher.runOnsetExtractor(filename);
    
    parseRhythmExtractorOutput(rhythmExtractorOutput);
    parseOnsetExtractorOutput(onsetExtractorOutput);
    
    return this.results;
  }
  
  private void parseRhythmExtractorOutput(String rhythmExtractorOutput) throws ExtractorException {
    String[] lines = rhythmExtractorOutput.split("\\n|\\r");
    
    System.out.println("rhythmExtractorOutput: " + rhythmExtractorOutput);
    
    if (lines.length != 9) {
      throw new ExtractorException();
    }
    
    String bpmLine = lines[4];
    this.results.setBpm(Float.parseFloat(bpmLine.split(":\\s+")[1]));
    
    //System.out.println("bpm: " + this.bpm);
    
    String ticksLine = lines[5];
    ArrayList<Float> ticks = new ArrayList<Float>();
    String ticksList = ticksLine.split("\\[|\\]")[1];
    List<String> ticksListString = Arrays.asList(ticksList.split(",\\s*+"));
    for (String s : ticksListString) {
      ticks.add(Float.parseFloat(s));
    }
    
    this.results.setTicks(ticks);
  }
  
  private void parseOnsetExtractorOutput(String onsetExtractorOutput) throws ExtractorException {
    String[] lines = onsetExtractorOutput.split("\\n|\\r");
    
    if (lines.length != 2) {
      throw new ExtractorException();
    }
    
    //String onsetTimes = lines[4];
    String onsetTimes = lines[1];
    String onsetsList = onsetTimes.split("\\[|\\]")[1];
    List<String> onsetsListString = Arrays.asList(onsetsList.split(",\\s*+"));

    ArrayList<Float> onsets = new ArrayList<Float>();
    
    System.out.println("Parse onsets:");
    
    for (String s : onsetsListString) {
      onsets.add(Float.parseFloat(s));
      System.out.print(s + ", ");
    }
    
    System.out.println();
    
    this.results.setOnsets(onsets);
  }
}
