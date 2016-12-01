package com.dsabsay.repo;

import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.UserConfiguration;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VexTabRhythmExercisesRepoTester {
  /**
   * Tester for VexTabRhythmExercisesRepo.
   * @param args args
   * @throws IOException if IO error occurs
   */
  public static void main(String[] args) throws IOException {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    
    try {
      VexTabExercisesRepo repo = new VexTabRhythmExercisesRepo(config);
    } catch (FileNotFoundException | InvalidVexTabException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
  }
}
