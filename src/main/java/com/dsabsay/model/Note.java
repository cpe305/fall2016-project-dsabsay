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

  public boolean getIsRest() {
    return isRest;
  }

  public void setIsRest(boolean isRest) {
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
  
  /*
  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!(other instanceof Note)) {
      return false;
    }
    
    Note otherNote = (Note) other;
    return this.rhythmicValue == otherNote.getRhythmicValue()
        && this.pitch == otherNote.getPitch()
        && this.isDotted == otherNote.getIsDotted()
        && this.isRest == otherNote.getIsRest()
        && this.tied == otherNote.getTied();
  }
  */
  
  public boolean getIsDotted() {
    return isDotted;
  }
  
  public void setIsDotted(boolean isDotted) {
    this.isDotted = isDotted;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (isDotted ? 1231 : 1237);
    result = prime * result + (isRest ? 1231 : 1237);
    result = prime * result + pitch;
    result = prime * result + rhythmicValue;
    result = prime * result + ((tied == null) ? 0 : tied.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Note other = (Note) obj;
    if (isDotted != other.isDotted) {
      return false;
    }
    if (isRest != other.isRest) {
      return false;
    }
    if (pitch != other.pitch) {
      return false;
    }
    if (rhythmicValue != other.rhythmicValue) {
      return false;
    }
    if (tied == null) {
      if (other.tied != null) {
        return false;
      }
    } else if (!tied.equals(other.tied)) {
      return false;
    }
    return true;
  }
}
