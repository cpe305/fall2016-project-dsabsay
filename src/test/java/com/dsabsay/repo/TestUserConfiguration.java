package com.dsabsay.repo;

import static org.junit.Assert.assertEquals;

import com.dsabsay.model.UserConfiguration;

import org.junit.Before;
import org.junit.Test;

public class TestUserConfiguration {

  UserConfiguration config;

  @Before
  public void setup() {
    config = new UserConfiguration();
  }

  @Test
  public void testReadWriteUserConfig() {
    config.readUserConfig();
    
    //not sure about this
    final String orig = config.getRhythmRecordsPath();
    
    config.setRhythmRecordsPath("test/");
    config.saveUserConfig();
    assertEquals(config.getRhythmRecordsPath(), "test/");
    config.setRhythmRecordsPath(orig);
    config.saveUserConfig();
    assertEquals(config.getRhythmRecordsPath(), orig);
  }
}
