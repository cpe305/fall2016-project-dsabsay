package com.dsabsay.repo;

import static org.junit.Assert.assertTrue;

import com.dsabsay.model.UserConfiguration;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestVexTabRhythmExercisesRepo {

  @Test
  public void test() {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    VexTabExercisesRepo repo = null;
    
    try {
      repo = new VexTabRhythmExercisesRepo(config);
    } catch (FileNotFoundException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }
    
    assertTrue(repo.getExercises() != null);
    assertTrue(repo.getExercises().size() >= 4);
  }

}
