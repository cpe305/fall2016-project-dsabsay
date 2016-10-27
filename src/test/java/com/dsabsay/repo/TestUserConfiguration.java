package com.dsabsay.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dsabsay.model.UserConfiguration;

public class TestUserConfiguration {
	
	UserConfiguration config;
	@Before
    public void setup() {        
        config = new UserConfiguration();
    }

	@Test
	public void testReadWriteUserConfig() {
		config.readUserConfig();
		String orig = config.getRhythmRecordsPath();
		config.setRhythmRecordsPath("test/");
		config.saveUserConfig();
		assertEquals(config.getRhythmRecordsPath(), "test/");
		config.setRhythmRecordsPath(orig);
		config.saveUserConfig();
		assertEquals(config.getRhythmRecordsPath(), orig);
	}
}
