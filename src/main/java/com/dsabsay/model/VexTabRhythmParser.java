package com.dsabsay.model;

import java.util.ArrayList;
import java.util.List;

public class VexTabRhythmParser {

  public RhythmExercise parseVexTab(String s) 
      throws InvalidVexTabException {
    int duration;
    boolean dotted;
    List<Note> notes = new ArrayList<Note>();
    
    //default duration values
    duration = 4;
    dotted = false;
    
    // parse time signature
    int index = s.indexOf("time=");
    if (index == -1) {
      throw new InvalidVexTabException();
    }
    int timeSigNumerator = Integer.parseInt(s.substring(index + 5, index + 6));
    int timeSigDenominator = Integer.parseInt(s.substring(index + 7, index + 8));
    
    //get lines starting with "notes"
    String noteLine;
    index = s.indexOf("notes");
    int indexOfNewline = s.substring(index).indexOf('\n');
    
    if (indexOfNewline == -1) {
      noteLine = s.substring(index);
    } else {
      noteLine = s.substring(index).substring(0, s.substring(index).indexOf('\n'));
    }
    
    //trim off "notes"
    noteLine = noteLine.substring(5);
    
    //right now this only parses one line of notes
    String[] tokens = noteLine.split("\\s+");
    
    System.out.println("tokens: ");
    
    /*
    for (String token: tokens) {
      System.out.println(token);
    }
    */
    
    for (String token : tokens) {
      System.out.println("Token: " + token);
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
          duration = Integer.parseInt(token.substring(1, 2));
        }
        //check for dotted note
        if (token.indexOf("d") > 1) {
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
    
    return new RhythmExercise(timeSigNumerator, timeSigDenominator, notes);
    
  }
  
}
