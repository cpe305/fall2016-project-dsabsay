package com.dsabsay.repo;

import com.dsabsay.model.Exercise;

import java.util.List;

public interface ExercisesRepo {
  public List<Exercise> getExercises();
  
  public Exercise getRandomExercise();
}
