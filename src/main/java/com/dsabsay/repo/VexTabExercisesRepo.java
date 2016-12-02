package com.dsabsay.repo;

import com.dsabsay.model.VexTabExercise;
import com.dsabsay.model.VexTabExerciseAbstractClass;

import java.util.List;

public interface VexTabExercisesRepo {
  public List<VexTabExercise> getExercises();
  
  public VexTabExercise getRandomExercise();
}
