package com.dsabsay.grader;

import com.dsabsay.model.Note;

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
  
  //converts a float duration to number of beats (based on the bpm)
  //assumes duration is measured in seconds
  private int tickToBeats(float duration) {
    float beatsPerSecond = this.bpm / 60;
    float beats = duration * beatsPerSecond;
    
    //need to round the beats
    int roundedBeats = Math.round(beats);
    
    return roundedBeats;
  }

  public List<Float> getTicks() {
    return ticks;
  }
}
