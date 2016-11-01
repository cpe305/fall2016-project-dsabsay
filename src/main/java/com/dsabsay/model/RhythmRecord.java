package com.dsabsay.model;

import java.io.Serializable;
import java.util.Date;

public class RhythmRecord extends PerformanceRecord implements Serializable {
  private int rhythmId;
  private String rhythmType;
  private float rhythmScore;
  private final String performanceType = "rhythm";

  public RhythmRecord() {
    super();
  }
  
  /**
   * Creates a RhythmRecord object.
   * @param rhythmId id of rhythm
   * @param rhythmType type of rhythm
   * @param totalScore total score
   * @param rhythmScore rhythm score
   * @param date date of performance
   * @param elapsedTimeSeconds time spent on performance
   */
  public RhythmRecord(int rhythmId, String rhythmType, float totalScore, float rhythmScore,
      Date date, int elapsedTimeSeconds) {
    super(totalScore, date, elapsedTimeSeconds);
    this.rhythmId = rhythmId;
    this.rhythmType = rhythmType;
    this.rhythmScore = rhythmScore;
  }
  
  public void print() {
    System.out.println("RhythmRecord: " + getrhythmId() + ", " + getRhythmType() + ", "
        + getTotalScore() + ", " + getRhythmScore() + ", " + getDate() + ", "
        + getElapsedTimeSeconds());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((performanceType == null) ? 0 : performanceType.hashCode());
    result = prime * result + rhythmId;
    result = prime * result + Float.floatToIntBits(rhythmScore);
    result = prime * result + ((rhythmType == null) ? 0 : rhythmType.hashCode());
    //result = prime * result + Float.floatToIntBits(totalScore);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    RhythmRecord other = (RhythmRecord) obj;
    if (performanceType == null) {
      if (other.performanceType != null) {
        return false;
      }
    } else if (!performanceType.equals(other.performanceType)) {
      return false;
    }
    if (rhythmId != other.rhythmId) {
      return false;
    }
    if (Float.floatToIntBits(rhythmScore) != Float.floatToIntBits(other.rhythmScore)) {
      return false;
    }
    if (rhythmType == null) {
      if (other.rhythmType != null) {
        return false;
      }
    } else if (!rhythmType.equals(other.rhythmType)) {
      return false;
    }
    /*
    if (Float.floatToIntBits(totalScore) != Float.floatToIntBits(other.totalScore)) {
      return false;
    }
    */
    return true;
  }

  public int getrhythmId() {
    return rhythmId;
  }

  public void setrhythmId(int rhythmId) {
    this.rhythmId = rhythmId;
  }

  public String getRhythmType() {
    return rhythmType;
  }

  public void setRhythmType(String rhythmType) {
    this.rhythmType = rhythmType;
  }

  /*
  public float getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(float totalScore) {
    this.totalScore = totalScore;
  }
  */

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
