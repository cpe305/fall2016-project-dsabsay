package com.dsabsay.grader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Scanner;

public class EssentiaExtractorLauncher {
  private static final String ESSENTIA_WORKING_DIRECTORY = "essentia/";
  private static final String RHYTHM_EXTRACTOR_PATH
      = "essentia-extractors/essentia_streaming_rhythmextractor_multifeature";
  private static final String ONSET_EXTRACTOR_PATH
      = "essentia-extractors/essentia_streaming_onsetrate";
  private static final String STANDARD_ONSET_EXTRACTOR_PATH
      = "essentia-extractors/essentia_standard_onsetrate";
  private static final int EXIT_SUCCESS = 0;
  
  public String runRhythmExtractor(String filename) {
    return processRhythmPerformance(getCommand(RHYTHM_EXTRACTOR_PATH, filename));
  }
  
  public String runOnsetExtractor(String filename) {
    //return processRhythmPerformance(ONSET_EXTRACTOR_PATH, filename);
    return processRhythmPerformance(getCommand(STANDARD_ONSET_EXTRACTOR_PATH, filename));
  }
  
  private String[] getCommand(String extractorPath, String filename) {
    String[] cmd = new String[2];
    cmd[0] = extractorPath;
    cmd[1] = filename;
    
    return cmd;
  }
  
  /** no it doesn't
   * Runs the Essentia extractor in a new process
   * @param filename Filename of recorded performance.
   *      The path is relative to ESSENTIA_WORKING_DIRECTORY.
   */
  protected String processRhythmPerformance(String[] cmd) {
    Runtime runtime = Runtime.getRuntime();
    
    File dir = new File(ESSENTIA_WORKING_DIRECTORY);
    
    Process extractor = null;
    try {
      extractor = runtime.exec(cmd, null, dir);
    } catch (IOException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
    
    InputStream output = extractor.getInputStream();
    InputStream error = extractor.getErrorStream();

    //wait for process to terminate
    try {
      if (extractor.waitFor() != EXIT_SUCCESS) {
        System.out.println("extractor exited with failure");
        Scanner scanner = new Scanner(error).useDelimiter("\\A");
        String string = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        System.out.println("error: " + string);
      }
    } catch (InterruptedException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
    
    //get output
    /*
    StringWriter writer = new StringWriter();
    IOUtils.copy(output, writer, null);
    String string = writer.toString();
    */
    
    Scanner scanner = new Scanner(output).useDelimiter("\\A");
    String string = scanner.hasNext() ? scanner.next() : "";
    scanner.close();
    
    //System.out.println("output of extractor:\n" + string);
    
    return string;
  }
}
