package com.dsabsay.repo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.dsabsay.model.UserConfiguration;

public class TestVexTabRhythmExercisesRepo {

  @Test
  public void test() {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    VexTabExercisesRepo repo = null;
    
    try {
      repo = new VexTabRhythmExercisesRepo(config);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    assertTrue(repo.getExercises() != null);
    assertTrue(repo.getExercises().size() >= 4);
  }

}
