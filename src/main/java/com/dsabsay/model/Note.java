package com.dsabsay.model;

public class Note {
  private int pitch;
  // 1 = whole note; 2 = half note; 4 = quarter note; 8 = eighth note...
  private int rhythmicValue;
  private Note tied;
  private boolean isRest;
  private boolean isDotted;
  
  public Note(int pitch, int rhythmicValue, boolean isDotted, boolean isRest) {
    this.pitch = pitch;
    this.rhythmicValue = rhythmicValue;
    this.isDotted = isDotted;
    this.isRest = isRest;
    this.tied = null;
  }
  
  public Note(int rhythmicValue, boolean isDotted, boolean isRest) {
    this.rhythmicValue = rhythmicValue;
    this.isDotted = isDotted;
    this.tied = null;
    this.isRest = isRest;
  }

  public boolean isRest() {
    return isRest;
  }

  public void setRest(boolean isRest) {
    this.isRest = isRest;
  }

  public int getPitch() {
    return pitch;
  }

  public void setPitch(int pitch) {
    this.pitch = pitch;
  }

  public int getRhythmicValue() {
    return rhythmicValue;
  }

  public void setRhythmicValue(int rhythmicValue) {
    this.rhythmicValue = rhythmicValue;
  }

  public Note getTied() {
    return tied;
  }

  public void setTied(Note tied) {
    this.tied = tied;
  }
  
  @Override
  public String toString() {
    return "" + (isRest ? "#" : "") + rhythmicValue + (isDotted ? "." : "") + " " ;
  }
  
  
}
