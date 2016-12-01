package com.dsabsay.grader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RhythmExtractorResults extends ExtractorResults {
  private float bpm;
  private List<Float> ticks;
  private List<Float> onsets;
  
  /**
   * Creates a RhythmExtractorResults object.
   * @param bpm bpm
   * @param ticks list of ticks
   * @param onsets list of onsets
   */
  public RhythmExtractorResults(float bpm, List<Float> ticks, List<Float> onsets) {
    this.bpm = bpm;
    this.ticks = ticks;
    this.onsets = onsets;
  }
  
  public RhythmExtractorResults() {
    
  }
  
  /**
   * Creates RhythmExtractorResults from extractor output.
   * @param rhythmExtractorOutput output from the rhythm extractor
   * @param onsetExtractorOutput output from the onset extractor
   */
  /*
  public RhythmExtractorResults(String rhythmExtractorOutput, String onsetExtractorOutput) {
    parseRhythmExtractorOutput(rhythmExtractorOutput);
    parseOnsetExtractorOutput(onsetExtractorOutput);
    //System.out.println("ticks: " + this.ticks);
  }
  */
  
  public List<Float> getOnsets() {
    return onsets;
  }

  public void setOnsets(List<Float> onsets) {
    this.onsets = onsets;
  }

  public void setTicks(List<Float> ticks) {
    this.ticks = ticks;
  }

  /*
  private void parseRhythmExtractorOutput(String rhythmExtractorOutput) {
    String[] lines = rhythmExtractorOutput.split("\\n|\\r");
    
    String bpmLine = lines[4];
    this.bpm = Float.parseFloat(bpmLine.split(":\\s+")[1]);
    
    //System.out.println("bpm: " + this.bpm);
    
    String ticksLine = lines[5];
    this.ticks = new ArrayList<Float>();
    String ticksList = ticksLine.split("\\[|\\]")[1];
    List<String> ticksListString = Arrays.asList(ticksList.split(",\\s*+"));
    for (String s : ticksListString) {
      this.ticks.add(Float.parseFloat(s));
    }
  }
  */
  
  /*
  private void parseOnsetExtractorOutput(String onsetExtractorOutput) {
    String[] lines = onsetExtractorOutput.split("\\n|\\r");
    
    String onsetTimes = lines[5];
    String onsetsList = onsetTimes.split("\\[|\\]")[1];
    List<String> onsetsListString = Arrays.asList(onsetsList.split(",\\s*+"));

    this.onsets = new ArrayList<Float>();
    
    for (String s : onsetsListString) {
      this.onsets.add(Float.parseFloat(s));
    }
  }
  */
  
  public float getBpm() {
    return bpm;
  }

  public void setBpm(float bpm) {
    this.bpm = bpm;
  }

  /**
   * Converts the ticks to a list of Note.
   * @return list of Note objects representing the notes of the performance
   */
  /*
  public List<Float> ticksToNotes() {
    //List<Note> notes = new ArrayList<Note>();
    List<Float> notes = new ArrayList<Float>();
    
    //first tick is first note
    //use bpm estimate for now?
    //loop through list of ticks, don't calculate duration for last tick
    for (int i = 0; i < this.ticks.size() - 1; i++) {
      float duration = this.ticks.get(i + 1) - this.ticks.get(i);
      int beats = tickToBeats(duration);
      
      //interprets all durations as being a note (any rests will simply get added to the preceding
      //note's duration
      //notes.add(new Note(beats, iDontKnow, false));
      //notes.add(beats);
    }
    
    return notes;
  }
  */
  
  //converts a float duration to number of beats (based on the bpm)
  //assumes duration is measured in seconds
  /*
  private int tickToBeats(float duration) {
    float beatsPerSecond = this.bpm / 60;
    float beats = duration * beatsPerSecond;
    
    //need to round the beats
    int roundedBeats = Math.round(beats);
    
    return roundedBeats;
  }
  */

  public List<Float> getTicks() {
    return ticks;
  }
}
