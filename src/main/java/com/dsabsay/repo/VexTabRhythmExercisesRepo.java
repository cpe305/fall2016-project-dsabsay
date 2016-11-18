package com.dsabsay.repo;

import com.dsabsay.model.UserConfiguration;
import com.dsabsay.model.VexTabExercise;
import com.dsabsay.model.VexTabRhythmExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class VexTabRhythmExercisesRepo
    implements VexTabExercisesRepo {
  private String rhythmsPath;
  List<VexTabExercise> exercises;
  
  public VexTabRhythmExercisesRepo(UserConfiguration config) 
      throws FileNotFoundException {
    this.rhythmsPath = config.getRhythmsPath();
    loadExercisesFromDisk();
  }
  
  public List<VexTabExercise> getExercises() {
    return exercises;
  }
  
  /**
   * Gets a random exercise from the repo. Returns null if there are no exercises.
   */
  public VexTabExercise getRandomExercise() {
    // This should probably check the size of the exercises list
    if (exercises == null) {
      return null;
    }
    
    if (exercises.size() == 0) {
      return null;
    }
    
    return this.exercises.get((int) (Math.random() * this.exercises.size()));
  }
  
  private void loadExercisesFromDisk() 
      throws FileNotFoundException {
    
    if (rhythmsPath == null) {
      throw new FileNotFoundException("userConfig.rhythmsPath is null");
    }
    
    System.out.println("loadExercisesFromDisk");
    File folder = new File(rhythmsPath);
    System.out.println(folder);
    
    if (!folder.isDirectory()) {
      throw new FileNotFoundException("userConfig.rhythmsPath is not a valid directory");
    }
    
    this.exercises = new ArrayList<VexTabExercise>();
    
    for (File fileEntry : folder.listFiles()) {
      System.out.println("Exercise: " + fileEntry.getName());
      //need to deal with exercise id and exercise type
      exercises.add(new VexTabRhythmExercise(1, "test", fileEntry.getPath()));
    }
    
    if (this.exercises.size() == 0) {
      throw new FileNotFoundException();
    }
  }
}
