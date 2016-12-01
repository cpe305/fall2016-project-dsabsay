package com.dsabsay.grader;

import java.io.IOException;

import com.dsabsay.model.ExtractorException;

public class PythonEssentiaExtractorLauncher
    extends EssentiaExtractorLauncher {
  private static final String PYTHON_ONSET_EXTRACTOR_PATH
      = "essentia-extractors/standard_onset_rate.py";
  private static final String PYTHON_RHYTHM_EXTRACTOR_PATH
      = "essentia-extractors/streaming_rhythmextractor_multifeature.py";
  
  @Override
  public String runRhythmExtractor(String filename) throws ExtractorException, IOException,
      InterruptedException {
    return super.processRhythmPerformance(getPythonCommand(PYTHON_RHYTHM_EXTRACTOR_PATH, filename));
  }
  
  @Override
  public String runOnsetExtractor(String filename) throws ExtractorException, IOException,
      InterruptedException {
    //return processRhythmPerformance(ONSET_EXTRACTOR_PATH, filename);
    return super.processRhythmPerformance(getPythonCommand(PYTHON_ONSET_EXTRACTOR_PATH, filename));
  }
  
  private String[] getPythonCommand(String extractorPath, String filename) {
    String[] cmd = new String[3];
    cmd[0] = "python";
    cmd[1] = extractorPath;
    cmd[2] = filename;
    
    return cmd;
  }
}
