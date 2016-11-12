package com.dsabsay.repo;

import com.dsabsay.model.UserConfiguration;

public class VexTabRhythmExercisesRepoTester {
  public static void main(String[] args) {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    VexTabExercisesRepo repo = new VexTabRhythmExercisesRepo(config);
  }
}
