package com.dsabsay.repo;

import com.dsabsay.model.PerformanceRecord;
import com.dsabsay.model.RhythmRecord;
import com.dsabsay.model.SightSingingRecord;
import com.dsabsay.model.UserConfiguration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultPerformanceRecordRepo implements PerformanceRecordRepo {

  //private static final String DEFAULT_RHYTHM_RECORDS_PATH = "repo/rhythmRecords.ser";
  private UserConfiguration config;
  private List<RhythmRecord> rhythmRecords;
  private List<SightSingingRecord> sightSingingRecords;
  
  private Logger logger = Logger.getLogger("com.dsabsay.application.DefaultPerformanceRecordRepo");

  /**
   * Creates a DefaultPerformanceRecordRepo, and trues to read records from the disk.
   * @param config user configuration
   * @throws ClassNotFoundException if a ClassNotFoundException is thrown
   */
  public DefaultPerformanceRecordRepo(UserConfiguration config) throws IOException,
      ClassNotFoundException {
    this.config = Objects.requireNonNull(config, "The 'config' argument must not be null.");
    
    //if there are no saved records, just continue without throwing exception
    try {
      this.readRhythmRecordsFromDisk();
    } catch (FileNotFoundException ex) {
      logger.log(Level.WARNING, "No saved rhythm records found.", ex);
    } catch (IOException ex) {
      logger.log(Level.WARNING, "Error reading rhythm records from disk.", ex);
    }
    
    //if there are no saved records, just continue without throwing exception
    try {
      this.readSightSingingRecordsFromDisk();
    } catch (FileNotFoundException ex) {
      logger.log(Level.WARNING, "No saved sight-singing records found.", ex);
    } catch (IOException ex) {
      logger.log(Level.WARNING, "Error reading sight-singing records from disk.", ex);
    }
    
  }

  @Override
  public List<SightSingingRecord> getSightSingingRecords() {
    return this.sightSingingRecords;
  }

  @Override
  public List<RhythmRecord> getRhythmRecords() {
    return this.rhythmRecords;
  }

  @Override
  public Map<String, List<SightSingingRecord>> getSightSingingRecordsByCategory() {
    Map<String, List<SightSingingRecord>> recordsByCategory = new HashMap<>();

    for (SightSingingRecord record : this.getSightSingingRecords()) {
      List<SightSingingRecord> previous;
      if (recordsByCategory.containsKey(record.getMelodyType())) {
        previous = recordsByCategory.get(record.getMelodyType());
      } else {
        previous = new ArrayList<>();
      }

      previous.add(record);
      recordsByCategory.put(record.getMelodyType(), previous);
    }

    return recordsByCategory;
  }

  @Override
  public Map<String, List<RhythmRecord>> getRhythmRecordsByCategory() {
    Map<String, List<RhythmRecord>> recordsByCategory = new HashMap<>();

    for (RhythmRecord record : this.getRhythmRecords()) {
      List<RhythmRecord> previous;
      if (recordsByCategory.containsKey(record.getRhythmType())) {
        previous = recordsByCategory.get(record.getRhythmType());
      } else {
        previous = new ArrayList<>();
      }

      previous.add(record);
      recordsByCategory.put(record.getRhythmType(), previous);
    }

    return recordsByCategory;
  }

  @Override
  public void savePerformanceRecord(PerformanceRecord record) throws IOException {
    String filePath;
    Object listToWrite;

    if (record instanceof RhythmRecord) {
      this.rhythmRecords.add((RhythmRecord) record);
      filePath = this.config.getRhythmRecordsPath();
      listToWrite = this.rhythmRecords;
    } else if (record instanceof SightSingingRecord) {
      this.sightSingingRecords.add((SightSingingRecord) record);
      filePath = this.config.getSightSingingRecordsPath();
      listToWrite = this.sightSingingRecords;
    } else {
      throw new IllegalArgumentException("Unknown rhythm record type: " + record.getClass());
    }
    
    OutputStream file = new FileOutputStream(filePath);
    OutputStream buffer = new BufferedOutputStream(file);
    ObjectOutput output = new ObjectOutputStream(buffer);
    output.writeObject(listToWrite);
    output.close();

  }

  private void readRhythmRecordsFromDisk() throws IOException, ClassNotFoundException {
    ObjectInput input;
    
    this.rhythmRecords = new ArrayList<RhythmRecord>();
    
    FileInputStream file = new FileInputStream(this.config.getRhythmRecordsPath());
    
    InputStream buffer = new BufferedInputStream(file);

    input = new ObjectInputStream(buffer);
    this.rhythmRecords = (List<RhythmRecord>) input.readObject();
    input.close();
    buffer.close();
    file.close();
    
  }

  private void readSightSingingRecordsFromDisk() throws IOException, ClassNotFoundException {
    ObjectInput input;
    
    this.sightSingingRecords = new ArrayList<SightSingingRecord>();
    
    FileInputStream file = new FileInputStream(this.config.getSightSingingRecordsPath());
    
    InputStream buffer
        = new BufferedInputStream(file);

    input = new ObjectInputStream(buffer);
    this.sightSingingRecords = (List<SightSingingRecord>) input.readObject();
    input.close();
    buffer.close();
    file.close();
    
  }
  
}
