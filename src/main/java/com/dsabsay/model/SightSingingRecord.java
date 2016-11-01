package com.dsabsay.model;

import java.io.Serializable;
import java.util.Date;

public class SightSingingRecord extends PerformanceRecord implements Serializable {
  private int melodyId;
  private String melodyType;
  private float pitchScore;
  private float rhythmScore;
  private final String performanceType = "sightsinging";

  public SightSingingRecord(){
    
  }
  
  /**
   * Creates SightSingingRecord object.
   * @param melodyId id of melody
   * @param melodyType type of melody
   * @param totalScore total score
   * @param pitchScore pitch score
   * @param rhythmScore rhythm score
   * @param date date of performance
   * @param elapsedTimeSeconds time spent on performance
   */
  public SightSingingRecord(int melodyId, String melodyType, float totalScore, float pitchScore,
      float rhythmScore, Date date, int elapsedTimeSeconds) {
    super(totalScore, date, elapsedTimeSeconds);
    this.melodyId = melodyId;
    this.melodyType = melodyType;
    this.pitchScore = pitchScore;
    this.rhythmScore = rhythmScore;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + melodyId;
    result = prime * result + ((melodyType == null) ? 0 : melodyType.hashCode());
    result = prime * result + ((performanceType == null) ? 0 : performanceType.hashCode());
    result = prime * result + Float.floatToIntBits(pitchScore);
    result = prime * result + Float.floatToIntBits(rhythmScore);
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
    SightSingingRecord other = (SightSingingRecord) obj;
    if (melodyId != other.melodyId) {
      return false;
    }
    if (melodyType == null) {
      if (other.melodyType != null) {
        return false;
      }
    } else if (!melodyType.equals(other.melodyType)) {
      return false;
    }
    if (performanceType == null) {
      if (other.performanceType != null) {
        return false;
      }
    } else if (!performanceType.equals(other.performanceType)) {
      return false;
    }
    if (Float.floatToIntBits(pitchScore) != Float.floatToIntBits(other.pitchScore)) {
      return false;
    }
    if (Float.floatToIntBits(rhythmScore) != Float.floatToIntBits(other.rhythmScore)) {
      return false;
    }
    return true;
  }

  public int getMelodyId() {
    return melodyId;
  }

  public void setMelodyId(int melodyId) {
    this.melodyId = melodyId;
  }

  public String getMelodyType() {
    return melodyType;
  }

  public void setMelodyType(String melodyType) {
    this.melodyType = melodyType;
  }

  public float getPitchScore() {
    return pitchScore;
  }

  public void setPitchScore(float pitchScore) {
    this.pitchScore = pitchScore;
  }

  public float getRhythmScore() {
    return rhythmScore;
  }

  public void setRhythmScore(float rhythmScore) {
    this.rhythmScore = rhythmScore;
  }

  public String getPerformanceType() {
    return performanceType;
  }

}
