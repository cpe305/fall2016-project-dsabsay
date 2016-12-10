package com.dsabsay.grader;

import com.dsabsay.model.ExtractorException;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class EssentiaExtractorLauncher {
  private static final String ESSENTIA_WORKING_DIRECTORY = "essentia/";
  /*
  private static final String RHYTHM_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_streaming_rhythmextractor_multifeature";
  private static final String ONSET_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_streaming_onsetrate";
  private static final String STANDARD_ONSET_EXTRACTOR_PATH
      = "essentia-extractors/osx-x86_64/essentia_standard_onsetrate";
      */
  private static final String STANDARD_ONSET_EXTRACTOR_NAME = "essentia_standard_onsetrate";
  private static final String RHYTHM_EXTRACTOR_NAME
      = "essentia_streaming_rhythmextractor_multifeature";
  private static final String OSX_EXTRACTOR_FOLDER = "essentia-extractors/osx_x86_64/";
  private static final String LINUX_EXTRACTOR_FOLDER = "essentia-extractors/linux_x86_64/";
  private static final String WINDOWS_EXTRACTOR_FOLDER = "essentia-extractors/win_i686/";
  private static final int EXIT_SUCCESS = 0;
  
  private String getExtractorFolder() throws ExtractorException {
    
    System.out.println(System.getProperty("os.arch"));
    // don't know if windows extractor binaries are 32 or 64 bit
    if (!System.getProperty("os.arch").contains("x86")
        && !System.getProperty("os.arch").contains("64") && !SystemUtils.IS_OS_WINDOWS) {
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
    } else if (SystemUtils.IS_OS_WINDOWS) {
      return WINDOWS_EXTRACTOR_FOLDER;
    } else {
      throw new ExtractorException("The " + SystemUtils.OS_NAME + " is not supported.");
    }

  }
  
  /**
   * Runs the rhythm extractor.
   * @param filename filename of the audio file to analyze
   * @return the output of the rhythm extractor
   * @throws ExtractorException if an extractor binary does not exist for the operating system
   * @throws IOException if an IO error occurs
   * @throws InterruptedException if the thread interrupted
   */
  public String runRhythmExtractor(String filename) throws ExtractorException, IOException,
      InterruptedException {
    //return processRhythmPerformance(getCommand(RHYTHM_EXTRACTOR_PATH, filename));
    return processRhythmPerformance(getCommand(getExtractorFolder()
        + RHYTHM_EXTRACTOR_NAME, filename));
  }
  
  /**
   * Runs the onset extractor.
   * @param filename filename of the audio file to analyze
   * @return the output of the onset extractor
   * @throws ExtractorException if an extractor binary does not exist for the operating system
   * @throws IOException if an IO error occurs
   * @throws InterruptedException if the thread is interrupted
   */
  public String runOnsetExtractor(String filename) throws ExtractorException, IOException,
      InterruptedException {
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
   * @throws ExtractorException if the extractor exits with an exit code != EXIT_SUCCESS
   */
  protected String processRhythmPerformance(String[] cmd) throws IOException, InterruptedException,
      ExtractorException {
    Runtime runtime = Runtime.getRuntime();
    
    File dir = new File(ESSENTIA_WORKING_DIRECTORY);
    
    Process extractor = runtime.exec(cmd, null, dir);
    
    InputStream output = extractor.getInputStream();
    InputStream error = extractor.getErrorStream();

    //wait for process to terminate
    int exit;
    if ((exit = extractor.waitFor()) != EXIT_SUCCESS) {
      throw new ExtractorException("Extractor exited with: " + exit);
      //System.out.println("extractor exited with failure");
      //Scanner scanner = new Scanner(error).useDelimiter("\\A");
      //String string = scanner.hasNext() ? scanner.next() : "";
      //scanner.close();
      //System.out.println("error: " + string);
    }
    
    error.close();
    
    //get output
    Scanner scanner = new Scanner(output).useDelimiter("\\A");
    String string = scanner.hasNext() ? scanner.next() : "";
    scanner.close();
    output.close();

    //System.out.println("output of extractor:\n" + string);
    
    return string;
  }
}
