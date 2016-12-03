package com.dsabsay.grader;

import static org.junit.Assert.assertEquals;

import com.dsabsay.model.ExtractorException;
import com.dsabsay.model.InvalidVexTabException;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.RhythmExercise;
import com.dsabsay.model.RhythmScore;
import com.dsabsay.model.VexTabRhythmExercise;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSimpleRhythmGrader {
  
  @Test
  public void testGetNoteOnsets1() throws FileNotFoundException, IOException,
      InvalidVexTabException {
    SimpleRhythmGrader grader = new SimpleRhythmGrader();
    List<Float> expected = new ArrayList<Float>();
    expected.add((float) 1.0);
    expected.add((float) 2.0);
    expected.add((float) 3.0);
    expected.add((float) 4.0);
    expected.add((float) 5.0);
    expected.add((float) 6.0);
    expected.add((float) 7.0);
    expected.add((float) 8.0);
    
    String path = "src/main/resources/testRhythmQuarterNotes.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    List<Float> results = grader.getNoteOnsets((float) 100, exercise.getExercise());
    
    System.out.println("Expected: " + expected);
    System.out.println("Results: " + results);
    
    assertEquals(expected, results);
    
    //assertEquals(expected, grader.getNote)

  }

  @Test
  public void testGetNoteOnsets2() throws FileNotFoundException, IOException,
      InvalidVexTabException {
    SimpleRhythmGrader grader = new SimpleRhythmGrader();
    List<Float> expected = new ArrayList<Float>();
    expected.add((float) 1.0);
    expected.add((float) 3.0);
    expected.add((float) 5.0);
    expected.add((float) 5.5);
    expected.add((float) 6.0);
    expected.add((float) 7.0);
    expected.add((float) 8.0);
    
    String path = "src/main/resources/testRhythm1.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    List<Float> results = grader.getNoteOnsets((float) 100, exercise.getExercise());
    
    System.out.println("Expected: " + expected);
    System.out.println("Results: " + results);
    
    assertEquals(expected, results);
    
    //assertEquals(expected, grader.getNote)

  }
  
  @Test
  public void testEvaluatePerformance() throws FileNotFoundException, IOException,
      InvalidVexTabException, ExtractorException, GraderException {
    SimpleRhythmGrader grader = new SimpleRhythmGrader();
    String path = "src/main/exercises/testRhythmExercises/testRhythmQuarterNotes.txt";
    VexTabRhythmExercise exercise = new VexTabRhythmExercise(1, "test", path);
    
    List<String> comments = new ArrayList<String>();
    comments.add("woohoo!");
    
    PerformanceScore expected = new RhythmScore((float) 1.0, comments, exercise);
    final float rhythmErrorMargin = (float) 0.20;
    String performanceFilename = "tap_quarterNotes.m4a";
    PerformanceScore results = grader.evaluatePerformance(exercise, performanceFilename,
        rhythmErrorMargin);
    
    assertEquals(expected.getScore(), results.getScore(), 0.0);
    assertEquals(expected.getComments(), results.getComments());
    assertEquals(expected.getExercise(), results.getExercise());
    
  }

}
