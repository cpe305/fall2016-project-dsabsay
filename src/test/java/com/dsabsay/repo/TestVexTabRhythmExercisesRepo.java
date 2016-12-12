package com.dsabsay.repo;

import static org.junit.Assert.assertTrue;

import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.UserConfiguration;
import org.junit.Test;

import java.io.IOException;

public class TestVexTabRhythmExercisesRepo {

  @Test
  public void test() throws IOException, InvalidVexTabException {
    UserConfiguration config = new UserConfiguration();
    config.setRhythmsPath("src/main/exercises/testRhythmExercises");
    ExercisesRepo repo = null;
    
    repo = new VexTabRhythmExercisesRepo(config);
    
    assertTrue(repo.getExercises() != null);
    assertTrue(repo.getExercises().size() >= 5);
  }
  
  @Test
  public void testDefaultRhythmsPath() throws IOException, InvalidVexTabException {
    UserConfiguration config = new UserConfiguration();
    ExercisesRepo repo = null;
    
    repo = new VexTabRhythmExercisesRepo(config);
    
    assertTrue(repo.getExercises() != null);
    assertTrue(repo.getExercises().size() >= 5);
  }

}
