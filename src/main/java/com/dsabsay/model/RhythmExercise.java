package com.dsabsay.model;

import java.util.List;

public class RhythmExercise {
  private int[] timeSig;
  private List<Note> notes;
  
  public RhythmExercise(int timeSigNumerator, int timeSigDenominator, List<Note> notes) {
    this.timeSig = new int[2];
    this.timeSig[0] = timeSigNumerator;
    this.timeSig[1] = timeSigDenominator;
    this.notes = notes;
  }
  
  public void printNotes() {
    for (Note n : notes) {
      System.out.println(n);
    }
  }
  
}
