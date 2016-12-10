package com.dsabsay.model;

import static org.junit.Assert.assertEquals;

import com.dsabsay.repo.DefaultPerformanceRecordRepo;
import com.dsabsay.repo.PerformanceRecordRepo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestProgress {
  private static UserConfiguration config;
  private PerformanceRecordRepo repo;
  private static final String SIGHT_SINGING_RECORD_PATH = "sightSingingRecords.ser";
  private static final String RHYTHM_RECORD_PATH = "rhythmRecords.ser";

  /**
   * Set up test suite.
   * @throws IOException if IO error occurs
   */
  @BeforeClass
  public static void setupSuite() throws IOException {
    config = new UserConfiguration();
    config.setRhythmRecordsPath(RHYTHM_RECORD_PATH);
    config.setSightSingingRecordsPath(SIGHT_SINGING_RECORD_PATH);
  }

  @Before
  public void setup() throws ClassNotFoundException, IOException {
    this.repo = new DefaultPerformanceRecordRepo(config);
  }

  @After
  public void teardown() {
    new File(SIGHT_SINGING_RECORD_PATH).delete();
    new File(RHYTHM_RECORD_PATH).delete();
  }
  
  @Test
  public void testGetDefaultStatsForRhythm() throws IOException, ClassNotFoundException {
    RhythmRecord record1 = new RhythmRecord(1, "rhythmType", "rhythmName", 1, 1, new Date(), 10);
    RhythmRecord record2 = new RhythmRecord(1, "rhythmType", "rhythmName", (float) .5, (float) .5,
        new Date(), 10);
    this.repo.savePerformanceRecord(record1);
    this.repo.savePerformanceRecord(record2);

    // if we reinstantiate the repo to read from disk, it should still be there
    this.repo = new DefaultPerformanceRecordRepo(config);
    
    Progress progress = new Progress();
    List<String> expected = new ArrayList<String>();
    expected.add("Total number of attempts:     " + 2);
    expected.add("Total number attempts passed (at least 80%):     " + 1);

    assertEquals(expected, progress.getDefaultStatsForRhythm(this.repo));
  }

}
