package com.dsabsay.grader;

import com.dsabsay.model.Note;
import com.dsabsay.model.PerformanceScore;
import com.dsabsay.model.RhythmExercise;
import com.dsabsay.model.RhythmScore;
import com.dsabsay.model.VexTabRhythmExercise;

import java.util.ArrayList;
import java.util.List;

public class SimpleRhythmGrader {
  
  /*
  public PerformanceScore evaluatePerformance(VexTabRhythmExercise vextabExercise,
      RhythmExtractorResults performance) {
    
    int numCorrect = 0;
    int numWrong = 0;
    int exerciseBeat = 0;
    int performanceBeat = 0;
    RhythmExercise exercise = vextabExercise.getExercise();
    
    //assume first tick of performance is beginning of rhythm
    
    
    return null;
    
  }
  */
  
  /**
   * Evaluates the rhythm performance.
   * @param vextabExercise the exercise
   * @param performance the performance (parsed as a RhythmExtractorResults object)
   * @param errorMargin acceptable margin of error for onsets
   * @return PerformanceScore containing the calculated score
   */
  public PerformanceScore evaluatePerformanceSimpler(VexTabRhythmExercise vextabExercise,
      RhythmExtractorResults performance, float errorMargin) {
    int numCorrect = 0;
    int numWrong = 0;
    //this gets number of notes including rests!
    //maybe just subtract rests for now
    //int numNotesInExercise = vextabExercise.getExercise().getNotes().size();
    
    //note onsets (in beats)
    List<Float> exerciseNoteOnsets = getNoteOnsets(performance.getBpm(),
        vextabExercise.getExercise());
    
    System.out.print("Exercise Note Onsets: ");
    for (float a : exerciseNoteOnsets) {
      System.out.print(a + ", ");
    }
    
    System.out.println();
    
    List<Float> performanceNoteOnsets = getNoteOnsets(performance);

    System.out.print("Performance Note Onsets: ");
    for (float a : performanceNoteOnsets) {
      System.out.print(a + ", ");
    }
    
    System.out.println();
    
    for (float f : performanceNoteOnsets) {
      if (hasNote(exerciseNoteOnsets, f, errorMargin)) {
        numCorrect++;
      } else {
        numWrong++;
      }
    }
    
    System.out.println("numCorrect: " + numCorrect);
    System.out.println("numWrong: " + numWrong);
    
    List<String> comments = new ArrayList<String>();
    comments.add("woohoo!");
    int numNotesInExercise = numNotesWithoutRests(vextabExercise.getExercise().getNotes());

    PerformanceScore score = new RhythmScore((numCorrect - numWrong) / (float) numNotesInExercise,
        comments);
    
    return score;
  }
  
  //searches for the note onset in exerciseNoteOnsets
  private boolean hasNote(List<Float> exerciseNoteOnsets, float onset, float errorMargin) {
    //just iterate through entire list for now
    for (float f : exerciseNoteOnsets) {
      if (onset < f + errorMargin && onset > f - errorMargin) {
        return true;
      }
    }
    
    return false;
  }
  
  //converts a float duration to number of beats (based on the bpm)
  //assumes duration is measured in seconds
  private float tickToBeats(float duration, float bpm) {
    float beatsPerSecond = bpm / (float) 60;
    float beats = duration * beatsPerSecond;
    
    return beats;
  }
  
  private List<Float> getTickOnsets(RhythmExtractorResults performance) {
    float bpm = performance.getBpm();
    List<Float> noteOnsets = new ArrayList<Float>();
    
    //add first note onset = 0;
    noteOnsets.add((float) 0.0);
    
    float start = performance.getTicks().get(0);
    
    List<Float> ticks = performance.getTicks();
    
    for (int i = 1; i < ticks.size(); i++) {
      float onset = ticks.get(i) - start;
      noteOnsets.add(tickToBeats(onset, bpm));
    }
    
    return noteOnsets;
  }
  
  private List<Float> getNoteOnsets(RhythmExtractorResults performance) {
    float bpm = performance.getBpm();
    List<Float> noteOnsets = new ArrayList<Float>();
    
    //add first note onset = 0;
    noteOnsets.add((float) 0.0);
    
    float start = performance.getOnsets().get(0);
    
    List<Float> onsets = performance.getOnsets();
    
    for (int i = 1; i < onsets.size(); i++) {
      float onset = onsets.get(i) - start;
      noteOnsets.add(tickToBeats(onset, bpm));
    }
    
    return noteOnsets;
  }
  
  //gets onsets (in beats) for the notes in the exercise
  private List<Float> getNoteOnsets(float bpm, RhythmExercise exercise) {
    List<Float> noteOnsets = new ArrayList<Float>();
    
    //add first note onset = 0
    noteOnsets.add((float) 0.0);
    int timeSigNumerator = exercise.getTimeSig()[0];
    int timeSigDenominator = exercise.getTimeSig()[1];
    
    float totalBeats = 0;
    
    //need to skip last note, or remember there is an onset for the next beat
    //after the end of the rhythm
    //this is getting rests too
    for (Note note : exercise.getNotes()) {
      int rhythmicValue = note.getRhythmicValue();
      //get number of beats for this note
      //float beats = rhythmicValue / (float) timeSigDenominator;
      float beats = timeSigDenominator / (float) rhythmicValue;
      totalBeats += beats;
      
      //only add if note is not a rest
      if (!note.getIsRest()) {
        noteOnsets.add(totalBeats);
      }
    }
    
    //remove last onset
    noteOnsets.remove(noteOnsets.size() - 1);
    
    return noteOnsets;
  }
  
  private int numNotesWithoutRests(List<Note> notes) {
    int num = 0;
    
    for (Note n : notes) {
      if (!n.getIsRest()) {
        num++;
      }
    }
    
    return num;
  }
  
  /*
  private float beatsToSeconds(float beats) {
  }
  */
  
}
