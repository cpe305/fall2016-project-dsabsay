package com.dsabsay.grader;

public class PythonEssentiaExtractorLauncher
    extends EssentiaExtractorLauncher {
  private static final String PYTHON_ONSET_EXTRACTOR_PATH
      = "essentia-extractors/standard_onset_rate.py";
  private static final String PYTHON_RHYTHM_EXTRACTOR_PATH
      = "essentia-extractors/streaming_rhythmextractor_multifeature.py";
  
  @Override
  public String runRhythmExtractor(String filename) {
    return super.processRhythmPerformance(getCommand(PYTHON_RHYTHM_EXTRACTOR_PATH, filename));
  }
  
  @Override
  public String runOnsetExtractor(String filename) {
    //return processRhythmPerformance(ONSET_EXTRACTOR_PATH, filename);
    return super.processRhythmPerformance(getCommand(PYTHON_ONSET_EXTRACTOR_PATH, filename));
  }
  
  private String[] getCommand(String extractorPath, String filename) {
    String[] cmd = new String[3];
    cmd[0] = "python";
    cmd[1] = extractorPath;
    cmd[2] = filename;
    
    return cmd;
  }
}
