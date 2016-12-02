package com.dsabsay.repo;

import java.util.List;

import com.dsabsay.model.Exercise;
import com.dsabsay.model.VexTabExercise;

public interface ExercisesRepo {
  public List<Exercise> getExercises();
  
  public Exercise getRandomExercise();
}
