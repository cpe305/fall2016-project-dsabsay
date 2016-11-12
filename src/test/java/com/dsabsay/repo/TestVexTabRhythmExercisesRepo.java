package com.dsabsay.repo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsabsay.model.UserConfiguration;

public class TestVexTabRhythmExercisesRepo {

  @Test
  public void test() {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    VexTabExercisesRepo repo = new VexTabRhythmExercisesRepo(config);
    
    assertTrue(repo.getExercises() != null);
    assertTrue(repo.getExercises().size() >= 4);
  }

}
