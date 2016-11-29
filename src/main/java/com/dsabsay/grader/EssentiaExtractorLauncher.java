package com.dsabsay.grader;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.dsabsay.model.ExtractorException;

public class EssentiaExtractorLauncher {
  private static final String ESSENTIA_WORKING_DIRECTORY = "essentia/";
  private static final String RHYTHM_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_streaming_rhythmextractor_multifeature";
  private static final String ONSET_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_streaming_onsetrate";
  private static final String STANDARD_ONSET_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_standard_onsetrate";
  private static final String STANDARD_ONSET_EXTRACTOR_NAME = "essentia_standard_onsetrate";
  private static final String RHYTHM_EXTRACTOR_NAME
      = "essentia_streaming_rhythmextractor_multifeature";
  private static final String OSX_EXTRACTOR_FOLDER = "essentia-extractors/osx_x86_64/";
  private static final String LINUX_EXTRACTOR_FOLDER = "essentia-extractors/linux_x86_64/";
  private static final int EXIT_SUCCESS = 0;
  
  private String getExtractorFolder() throws ExtractorException {
    
    if (!System.getProperty("os.arch").contains("x86")
        || !System.getProperty("os.arch").contains("64")) {
      throw new ExtractorException("The extractor binaries only work on an x86_64 architecture.");
    }
    
    /*
    String os = System.getProperty("os.name");
    
    if (System.getProperty("os.name") == "Mac OS X") {
      return OSX_EXTRACTOR_FOLDER;
    }
    */
    
    if (SystemUtils.IS_OS_MAC_OSX) {
      return OSX_EXTRACTOR_FOLDER;
    } else if (SystemUtils.IS_OS_LINUX) {
      return LINUX_EXTRACTOR_FOLDER;
    } else {
      throw new ExtractorException("The " + SystemUtils.OS_NAME + " is not supported.");
    }

  }
  
  public String runRhythmExtractor(String filename) throws ExtractorException {
    //return processRhythmPerformance(getCommand(RHYTHM_EXTRACTOR_PATH, filename));
    return processRhythmPerformance(getCommand(getExtractorFolder()
        + RHYTHM_EXTRACTOR_NAME, filename));
  }
  
  public String runOnsetExtractor(String filename) throws ExtractorException {
    //return processRhythmPerformance(ONSET_EXTRACTOR_PATH, filename);
    //return processRhythmPerformance(getCommand(STANDARD_ONSET_EXTRACTOR_PATH, filename));
    return processRhythmPerformance(getCommand(getExtractorFolder()
        + STANDARD_ONSET_EXTRACTOR_NAME, filename));
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
