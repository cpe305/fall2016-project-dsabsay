package com.dsabsay.main;

import java.io.IOException;
import java.util.List;

import com.dsabsay.model.SightSingingRecord;
import com.dsabsay.model.UserConfiguration;
import com.dsabsay.repo.DefaultPerformanceRecordRepo;
import com.dsabsay.repo.PerformanceRecordRepo;

public class SightSinger {
    public static void main(String args[]) throws IOException {
        UserConfiguration config = new UserConfiguration();
        config.setRhythmRecordsPath("rhythmRecords.ser");
        config.setSightSingingRecordsPath("sightSingingRecords.ser");

        PerformanceRecordRepo repo = new DefaultPerformanceRecordRepo(config);

        SightSingingRecord ssr = new SightSingingRecord(0, null, 0, 10, 0, null, 0);
        repo.savePerformanceRecord(ssr);
        
        List<SightSingingRecord> records = repo.getSightSingingRecords();
        for (SightSingingRecord r : records) {
            System.out.println(r.getPitchScore());
        }
    }
}
