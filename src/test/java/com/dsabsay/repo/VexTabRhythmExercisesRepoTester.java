package com.dsabsay.repo;

import java.io.FileNotFoundException;

import com.dsabsay.model.UserConfiguration;

public class VexTabRhythmExercisesRepoTester {
  public static void main(String[] args) {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    
    try {
      VexTabExercisesRepo repo = new VexTabRhythmExercisesRepo(config);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
