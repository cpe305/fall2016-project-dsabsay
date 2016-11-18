package com.dsabsay.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestVexTabRhythmParser {

  @Test
  public void testVexTabRhythmParser1() {
    String path = "src/main/resources/testRhythm1.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    List<Note> notes = new ArrayList<Note>();
    notes.add(new Note(2, false, false));
    notes.add(new Note(4, false, false));
    notes.add(new Note(4, false, true));
    notes.add(new Note(8, false, false));
    notes.add(new Note(8, false, false));
    notes.add(new Note(4, false, false));
    notes.add(new Note(4, false, false));
    notes.add(new Note(4, false, false));
    
    int[] timeSig = {4, 4};
    RhythmExercise expected = new RhythmExercise(4, 4, notes);
    RhythmExercise parsed = exercise.getExercise();
    
    assertArrayEquals(timeSig, parsed.getTimeSig());
    assertEquals(notes, parsed.getNotes());
  }
  
  @Test
  public void testVexTabRhythmParser2() {
    String path = "src/main/resources/testRhythm2.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    List<Note> notes = new ArrayList<Note>();
    notes.add(new Note(2, false, false));
    notes.add(new Note(2, false, false));
    notes.add(new Note(8, false, false));
    notes.add(new Note(8, false, false));
    notes.add(new Note(4, false, false));
    notes.add(new Note(4, false, true));
    notes.add(new Note(4, false, false));

    int[] timeSig = {4, 4};
    RhythmExercise expected = new RhythmExercise(4, 4, notes);
    RhythmExercise parsed = exercise.getExercise();
    
    assertArrayEquals(timeSig, parsed.getTimeSig());
    assertEquals(notes, parsed.getNotes());
  }

}
