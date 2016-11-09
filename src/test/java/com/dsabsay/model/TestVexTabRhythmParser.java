package com.dsabsay.model;

public class TestVexTabRhythmParser {
  public static void main(String[] args) {
    //String path = TestVexTabRhythmParser.class.getClassLoader().getResource("rhythm1.txt").toString();
    //String path = "/resources/rhythm1.txt";
    String path = "src/main/resources/rhythm1.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    exercise.getExercise().printNotes();
  }
}
