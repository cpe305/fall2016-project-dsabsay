package com.dsabsay.model;

import java.util.ArrayList;
import java.util.List;

import com.dsabsay.repo.PerformanceRecordRepo;

public class Progress {
  public List<String> getDefaultStatsForRhythm(PerformanceRecordRepo repo) {
    System.out.println("repo: " + repo);
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
    stats.add("Total number attempts passed:     " + numberPassed);
    
    return stats;
  }
}
