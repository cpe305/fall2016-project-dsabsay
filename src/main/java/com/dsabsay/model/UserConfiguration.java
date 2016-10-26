package com.dsabsay.model;

import java.util.HashMap;

/*
 * Stores information about the user's configuration.
 * This information will be read from the disk when the application is loaded.
 */
public class UserConfiguration {
    private HashMap<String, String> melodyTypes;
    private HashMap<String, String> rhythmTypes;
    private String sightSingingRecordsPath;
    private String rhythmRecordsPath;
    
    private String rhythmsPath;

    public HashMap<String, String> getMelodyTypes() {
        return melodyTypes;
    }

    public void setMelodyTypes(HashMap<String, String> melodyTypes) {
        this.melodyTypes = melodyTypes;
    }

    public HashMap<String, String> getRhythmTypes() {
        return rhythmTypes;
    }

    public void setRhythmTypes(HashMap<String, String> rhythmTypes) {
        this.rhythmTypes = rhythmTypes;
    }

    public String getSightSingingRecordsPath() {
        return sightSingingRecordsPath;
    }

    public void setSightSingingRecordsPath(String sightSingingRecordsPath) {
        this.sightSingingRecordsPath = sightSingingRecordsPath;
    }

    public String getRhythmRecordsPath() {
        return rhythmRecordsPath;
    }

    public void setRhythmRecordsPath(String rhythmRecordsPath) {
        this.rhythmRecordsPath = rhythmRecordsPath;
    }

}
