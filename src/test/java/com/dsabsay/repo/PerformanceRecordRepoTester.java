package com.dsabsay.repo;

import com.dsabsay.model.SightSingingRecord;
import com.dsabsay.model.UserConfiguration;
import com.dsabsay.repo.DefaultPerformanceRecordRepo;
import com.dsabsay.repo.PerformanceRecordRepo;

import java.io.IOException;
import java.util.List;

public class PerformanceRecordRepoTester {
  /**
   * May not be used.
   * @param args arguments
   * @throws IOException if repo.savePerformanceRecord() throws IOException
   * @throws ClassNotFoundException if a ClassNotFoundException is thrown
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
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
