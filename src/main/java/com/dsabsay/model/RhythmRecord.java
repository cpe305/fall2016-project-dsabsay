package com.dsabsay.model;

import java.io.Serializable;
import java.util.Date;

public class RhythmRecord extends PerformanceRecord implements Serializable {
    private int rhythmID;
    private String rhythmType;
    private float totalScore;
    private float rhythmScore;
    private final String performanceType = "rhythm";

    public RhythmRecord() {
    }

    public RhythmRecord(int rhythmID, String rhythmType, float totalScore, float rhythmScore, Date date,
            int elapsedTimeSeconds) {
        super(totalScore, date, elapsedTimeSeconds);
        this.rhythmID = rhythmID;
        this.rhythmType = rhythmType;
        this.totalScore = totalScore;
        this.rhythmScore = rhythmScore;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((performanceType == null) ? 0 : performanceType.hashCode());
        result = prime * result + rhythmID;
        result = prime * result + Float.floatToIntBits(rhythmScore);
        result = prime * result + ((rhythmType == null) ? 0 : rhythmType.hashCode());
        result = prime * result + Float.floatToIntBits(totalScore);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        RhythmRecord other = (RhythmRecord) obj;
        if (performanceType == null) {
            if (other.performanceType != null)
                return false;
        } else if (!performanceType.equals(other.performanceType))
            return false;
        if (rhythmID != other.rhythmID)
            return false;
        if (Float.floatToIntBits(rhythmScore) != Float.floatToIntBits(other.rhythmScore))
            return false;
        if (rhythmType == null) {
            if (other.rhythmType != null)
                return false;
        } else if (!rhythmType.equals(other.rhythmType))
            return false;
        if (Float.floatToIntBits(totalScore) != Float.floatToIntBits(other.totalScore))
            return false;
        return true;
    }

    public int getRhythmID() {
        return rhythmID;
    }

    public void setRhythmID(int rhythmID) {
        this.rhythmID = rhythmID;
    }

    public String getRhythmType() {
        return rhythmType;
    }

    public void setRhythmType(String rhythmType) {
        this.rhythmType = rhythmType;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
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
