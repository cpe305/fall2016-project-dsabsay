package com.dsabsay.repo;

import com.dsabsay.model.Exercise;
import com.dsabsay.model.VexTabExercise;

import java.util.List;

public interface ExercisesRepo {
  public List<Exercise> getExercises();
  
  public Exercise getRandomExercise();
}
