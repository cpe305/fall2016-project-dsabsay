package com.dsabsay.repo;

import com.dsabsay.model.UserConfiguration;
import com.dsabsay.model.VexTabExercise;
import com.dsabsay.model.VexTabRhythmExercise;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VexTabRhythmExercisesRepo
    implements VexTabExercisesRepo {
  private String rhythmsPath;
  List<VexTabExercise> exercises;
  
  public VexTabRhythmExercisesRepo(UserConfiguration config) {
    this.rhythmsPath = config.getRhythmsPath();
    loadExercisesFromDisk();
  }
  
  public List<VexTabExercise> getExercises() {
    return exercises;
  }
  
  public VexTabExercise getRandomExercise() {
    if (exercises == null) {
      return null;
    }
    
    return this.exercises.get((int) (Math.random() * this.exercises.size()));
  }
  
  private void loadExercisesFromDisk() {
    System.out.println("loadExercisesFromDisk");
    File folder = new File(rhythmsPath);
    System.out.println(folder);
    
    this.exercises = new ArrayList<VexTabExercise>();
    
    for (File fileEntry : folder.listFiles()) {
      System.out.println("Exercise: " + fileEntry.getName());
      //need to deal with exercise id and exercise type
      exercises.add(new VexTabRhythmExercise(1, "test", fileEntry.getPath()));
    }
  }
}
