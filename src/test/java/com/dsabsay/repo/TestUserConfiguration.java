package com.dsabsay.repo;

import static org.junit.Assert.assertEquals;

import com.dsabsay.model.UserConfiguration;

import org.junit.Before;
import org.junit.Test;

public class TestUserConfiguration {

  UserConfiguration config, config2;

  @Before
  public void setup() {
    config = new UserConfiguration();
    config2 = new UserConfiguration();
  }

  @Test
  public void testReadWriteUserConfig() {
    config.readUserConfig();
    String orig = config.getRhythmRecordsPath();
    config.setRhythmRecordsPath("test/");
    config.saveUserConfig();
    assertEquals(config.getRhythmRecordsPath(), "test/");
    
    config.readUserConfig();
    config2.setRhythmRecordsPath("test/");
    config2.saveUserConfig();
    assertEquals(config2.getRhythmRecordsPath(), "test/");
    
    config.setRhythmRecordsPath(orig);
    config.saveUserConfig();
    assertEquals(config.getRhythmRecordsPath(), orig);
  }
}
