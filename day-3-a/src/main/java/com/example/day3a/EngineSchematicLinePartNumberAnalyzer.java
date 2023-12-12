package com.example.day3a;

import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class EngineSchematicLinePartNumberAnalyzer {
    /*
    If a symbol (not a digit or period) exists above, below, to the right, to the left, or diagonally from any
    digit in the number, include the value of the number in the result.
     */
    public boolean isPartNumber(MatchResult match, String previousLine, String currentLine, String nextLine) {

        if (match.start() > 0) {
           if (isSymbol(previousLine.charAt(match.start()-1))) {
               return true;
           }
        }
        return false;
    }

    public boolean isSymbol(char c) {
        if ((c >= '0' && c <= '9') || c == '.') {
            return false;
        }
        return true;
    }
}
