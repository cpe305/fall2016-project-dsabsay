package com.dsabsay.repo;

import com.dsabsay.model.UserConfiguration;

import java.io.FileNotFoundException;

public class VexTabRhythmExercisesRepoTester {
  /**
   * Tester for VexTabRhythmExercisesRepo.
   * @param args args
   */
  public static void main(String[] args) {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    
    try {
      VexTabExercisesRepo repo = new VexTabRhythmExercisesRepo(config);
    } catch (FileNotFoundException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
  }
}
