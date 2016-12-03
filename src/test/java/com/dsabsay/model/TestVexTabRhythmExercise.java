package com.dsabsay.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestVexTabRhythmExercise {

  @Test
  public void testGetNotesString() throws FileNotFoundException, IOException,
      InvalidVexTabException {
    final String exercisePath = "src/main/exercises/testRhythmExercises/testRhythm1.txt";
    VexTabRhythmExercise results = new VexTabRhythmExercise(1, "test", exercisePath, "name");
    
    String expectedNotesString = "notes :2S B/4 :qS B/4 :q ## | :8S B/4 B/4 :qS B-B-B/4";
    //String expectedTimeSig = "4/4";
    
    assertEquals(expectedNotesString, results.getNotesString());
  }
  
  @Test
  public void testGetTimeSig() throws FileNotFoundException, IOException,
      InvalidVexTabException {
    final String exercisePath = "src/main/exercises/testRhythmExercises/testRhythm1.txt";
    VexTabRhythmExercise results = new VexTabRhythmExercise(1, "test", exercisePath, "name");
    
    String expectedTimeSig = "4/4 ";
    
    assertEquals(expectedTimeSig, results.getTimeSig());
  }
  
  /*
  @Test
  public void testExercise() throws FileNotFoundException, IOException,
      InvalidVexTabException {
    final String exercisePath = "src/main/exercises/testRhythmExercises/testRhythm1.txt";
    VexTabRhythmExercise results = new VexTabRhythmExercise(1, "test", exercisePath, "name");
    
    VexTabRhythmParser parser = new VexTabRhythmParser();
    RhythmExercise expectedRhythmExercise = parser.parseVexTab(results.getVexTabNotation());
    
    //this actually tests the parser
    List<Note> expectedNotes = new ArrayList<Note>();
    expectedNotes.add(new Note(2, false, false));
    expectedNotes.add(new Note(4, false, false));
    expectedNotes.add(new Note(4, false, true));
    expectedNotes.add(new Note(8, false, false));
    expectedNotes.add(new Note(8, false, false));
    expectedNotes.add(new Note(4, false, false));
    expectedNotes.add(new Note(4, false, false));
    expectedNotes.add(new Note(4, false, false));
    
    int[] expectedTimeSig = {4, 4};
    
    assertEquals(expectedNotes, results.getExercise().getNotes());
    assertEquals(expectedTimeSig, results.getExercise().getTimeSig());
  }
  */

}
