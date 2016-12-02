package com.dsabsay.model;

import java.util.ArrayList;
import java.util.List;

public class VexTabRhythmParser {

  /**
   * Parses VexTab notation and returns a RhythmExercise representing the exercise.
   * @param vextab String containing the VexTab notation to be parsed
   * @return RhythmExercise
   * @throws InvalidVexTabException if 
   */
  public RhythmExercise parseVexTab(String vextab) 
      throws InvalidVexTabException {
    int duration;
    boolean dotted;
    List<Note> notes = new ArrayList<Note>();
    
    //default duration values
    duration = 4;
    dotted = false;
    

    int index;
    //get lines starting with "notes"
    String noteLine;
    index = vextab.indexOf("notes");
    int indexOfNewline = vextab.substring(index).indexOf('\n');
    
    if (indexOfNewline == -1) {
      noteLine = vextab.substring(index);
    } else {
      noteLine = vextab.substring(index).substring(0, vextab.substring(index).indexOf('\n'));
    }
    
    //trim off "notes"
    noteLine = noteLine.substring(5);
    
    //right now this only parses one line of notes
    String[] tokens = noteLine.split("\\s+");
    
    //System.out.println("tokens: ");
    
    /*
    for (String token: tokens) {
      System.out.println(token);
    }
    */
    
    for (String token : tokens) {
      //System.out.println("Token: " + token);
      if (token.length() == 0) {
        continue;
      }
      
      // ":" - get new duration
      // duration is not always an integer
      // Durations: w, h, q, 8, 16, 32
      if (token.charAt(0) == ':') {
        //String duration
        if (token.charAt(1) == 'w') {
          duration = 1;
        } else if (token.charAt(1) == 'h') {
          duration = 2;
        } else if (token.charAt(1) == 'q') {
          duration = 4;
        } else {
          //what if the duration is more than 1 digit?
          int endOfDuration = 2;
          for (int i = 2; i < token.length(); i++) {
            if (Character.isDigit(token.charAt(i))) {
              endOfDuration++;
            }
          }
          duration = Integer.parseInt(token.substring(1, endOfDuration));
        }
        //check for dotted note
        if (token.indexOf('d') > 1) {
          dotted = true;
        } else {
          dotted = false;
        }
        continue;
      }
      
      // '|' - barline
      if (token.charAt(0) == '|') {
        continue;
      }
      
      // '=' - barlines
      if (token.charAt(0) == '=') {
        continue;
      }
      
      // '#' - rest
      if (token.charAt(0) == '#') {
        // add a rest
        notes.add(new Note(duration, dotted, true));
        continue;
      }
      
      // '^' - tuplets
      if (token.charAt(0) == '^') {
        continue;
      }
      
      //notes!
      //probably can just add a note with the proper duration at this point without parsing the rest
      //of the token
      //need to check for dashes
      String[] parts = token.split("-");
      
      // multiple notes separated by "-"
      if (parts.length > 1) {
        for (int a = 0; a < parts.length; a++) {
          notes.add(new Note(duration, dotted, false));
        }
      } else {
        notes.add(new Note(duration, dotted, false));
      }
      
      /*
      int i = 0;
      for (i = 0; i < token.length(); i++) {
      }
      */
    }
    
    // iterate through tokens
    /*
    char c;
    int i;
    while (s.charAt(i) != '\n') {
      
      // ":"
      if (c == ':') {
        i++;
        duration = Integer.parseInt(s.substring(i, i));
        //ignore anything else after the duration, skip to next token
      }
    }
    // if newline is read, look for next "notes" line
    */
    
    // parse time signature
    // This code might be duplicated in VexTabRhythmExercise.getTimeSig()
    index = vextab.indexOf("time=");
    if (index == -1) {
      throw new InvalidVexTabException();
    }
    
    int timeSigNumerator = Integer.parseInt(vextab.substring(index + 5, index + 6));
    int timeSigDenominator = Integer.parseInt(vextab.substring(index + 7, index + 8));
    
    return new RhythmExercise(timeSigNumerator, timeSigDenominator, notes);
    
  }
  
}
