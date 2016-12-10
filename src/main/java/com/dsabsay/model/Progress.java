package com.dsabsay.model;

import com.dsabsay.repo.PerformanceRecordRepo;

import java.util.ArrayList;
import java.util.List;

public class Progress {
  /**
   * Get default stats for rhythm.
   * @param repo repo
   * @return list of strings containing stats for the records stored in the repo
   */
  public List<String> getDefaultStatsForRhythm(PerformanceRecordRepo repo) {
    List<RhythmRecord> records = repo.getRhythmRecords();
    
    int numberAttempts = records.size();
    int numberPassed = 0;
    
    for (RhythmRecord r : records) {
      if (r.getTotalScore() > .80) {
        numberPassed++;
      }
    }
    
    List<String> stats = new ArrayList<String>();
    stats.add("Total number of attempts:     " + numberAttempts);
    stats.add("Total number attempts passed (at least 80%):     " + numberPassed);
    
    return stats;
  }
}
