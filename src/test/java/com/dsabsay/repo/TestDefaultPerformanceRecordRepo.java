package com.dsabsay.repo;

import com.dsabsay.model.RhythmRecord;
import com.dsabsay.model.SightSingingRecord;
import com.dsabsay.model.UserConfiguration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestDefaultPerformanceRecordRepo {
  private static UserConfiguration config;
  private PerformanceRecordRepo repo;
  private static final String SIGHT_SINGING_RECORD_PATH = "sightSingingRecords.ser";
  private static final String RHYTHM_RECORD_PATH = "rhythmRecords.ser";

  /**
   * Set up test suite.
   */
  @BeforeClass
  public static void setupSuite() {
    config = new UserConfiguration();
    config.setRhythmRecordsPath(RHYTHM_RECORD_PATH);
    config.setSightSingingRecordsPath(SIGHT_SINGING_RECORD_PATH);
  }

  @Before
  public void setup() {
    this.repo = new DefaultPerformanceRecordRepo(config);
  }

  @After
  public void teardown() {
    new File(SIGHT_SINGING_RECORD_PATH).delete();
    new File(RHYTHM_RECORD_PATH).delete();
  }

  @Test
  public void testSaveSightSingingRecord() throws IOException {
    SightSingingRecord record = new SightSingingRecord(1, "melodyType", 1, 1, 1, new Date(), 10);
    this.repo.savePerformanceRecord(record);

    List<SightSingingRecord> records = repo.getSightSingingRecords();
    Assert.assertTrue(records.contains(record));
    Assert.assertEquals(1, records.size());

    // if we reinstantiate the repo to read from disk, it should still be there
    this.repo = new DefaultPerformanceRecordRepo(config);

    records = repo.getSightSingingRecords();
    Assert.assertTrue(records.contains(record));
    Assert.assertEquals(1, records.size());
  }

  @Test
  public void testSaveRhythmRecord() throws IOException {
    RhythmRecord record = new RhythmRecord(1, "rhythmType", 1, 1, new Date(), 10);
    this.repo.savePerformanceRecord(record);

    List<RhythmRecord> records = repo.getRhythmRecords();
    Assert.assertTrue(records.contains(record));
    Assert.assertEquals(1, records.size());

    // if we reinstantiate the repo to read from disk, it should still be there
    this.repo = new DefaultPerformanceRecordRepo(config);

    records = repo.getRhythmRecords();
    Assert.assertTrue(records.contains(record));
    Assert.assertEquals(1, records.size());
  }
}
