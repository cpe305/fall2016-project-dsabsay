package com.dsabsay.repo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.dsabsay.model.UserConfiguration;

import org.junit.Before;
import org.junit.Test;

public class TestUserConfiguration {

  UserConfiguration config;

  @Before
  public void setup() throws IOException {
    config = new UserConfiguration();
  }

  @Test
  public void testReadWriteUserConfig() throws IOException {
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
