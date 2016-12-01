package com.dsabsay.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;


public class TestRecorder {
  private static final String ESSENTIA_WORKING_DIRECTORY = "essentia/";
  private static final String PERFORMANCE_FILENAME = "performance.wav";
  
  /*
  @Test
  public void test() throws IOException, LineUnavailableException, RecorderException, Throwable {
    //delete old file
    File oldFile = new File(ESSENTIA_WORKING_DIRECTORY + PERFORMANCE_FILENAME);
    oldFile.delete();
    
    Recorder recorder = new Recorder();
    recorder.startRecording();
    
    Thread.sleep(3000);
    
    String performanceFilename = recorder.stopRecording();
    //String performanceFilename = "performance.wav";
    
    File file = new File(ESSENTIA_WORKING_DIRECTORY + performanceFilename);
    assertTrue(file.isFile());
    assertTrue(file.length() > 100000);
    
  }
  */

}
