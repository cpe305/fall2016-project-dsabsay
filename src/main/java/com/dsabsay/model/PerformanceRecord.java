package com.dsabsay.model;

import java.util.Date;

public abstract class PerformanceRecord {
  private float totalScore;
  private int elapsedTimeSeconds;
  private Date date;

  /**
   * Creates a PerformanceRecord object.
   * 
   * @param totalScore total score
   * @param date date of performance
   * @param elapsedTimeSeconds time spent on performance
   */
  public PerformanceRecord(float totalScore, Date date, int elapsedTimeSeconds) {
    this.totalScore = totalScore;
    this.date = date;
    this.elapsedTimeSeconds = elapsedTimeSeconds;
  }

  public float getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(float totalScore) {
    this.totalScore = totalScore;
  }

  public int getElapsedTimeSeconds() {
    return elapsedTimeSeconds;
  }

  public void setElapsedTimeSeconds(int elapsedTimeSeconds) {
    this.elapsedTimeSeconds = elapsedTimeSeconds;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + elapsedTimeSeconds;
    result = prime * result + Float.floatToIntBits(totalScore);
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
    PerformanceRecord other = (PerformanceRecord) obj;
    if (date == null) {
      if (other.date != null) {
        return false;
      }
    } else if (!date.equals(other.date)) {
      return false;
    }
    if (elapsedTimeSeconds != other.elapsedTimeSeconds) {
      return false;
    }
    if (Float.floatToIntBits(totalScore) != Float.floatToIntBits(other.totalScore)) {
      return false;
    }
    return true;
  }

}
