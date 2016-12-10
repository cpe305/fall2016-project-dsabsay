package com.dsabsay.grader;

import java.util.List;

public class RhythmExtractorResults {
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
  
  public List<Float> getOnsets() {
    return onsets;
  }

  public void setOnsets(List<Float> onsets) {
    this.onsets = onsets;
  }

  public void setTicks(List<Float> ticks) {
    this.ticks = ticks;
  }
  
  public float getBpm() {
    return bpm;
  }

  public void setBpm(float bpm) {
    this.bpm = bpm;
  }

  public List<Float> getTicks() {
    return ticks;
  }
}
