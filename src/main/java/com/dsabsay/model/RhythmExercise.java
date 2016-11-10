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
  
  public int[] getTimeSig() {
    return timeSig;
  }

  public void setTimeSig(int[] timeSig) {
    this.timeSig = timeSig;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  public void print() {
    System.out.println("Exercise: timeSig: " + timeSig[0] + "/" + timeSig[1]);
    System.out.print("  Notes: ");
    printNotes();
    System.out.println("");
  }
  
  private void printNotes() {
    for (Note n : notes) {
      System.out.print(n + ", ");
    }
  }
  
}
