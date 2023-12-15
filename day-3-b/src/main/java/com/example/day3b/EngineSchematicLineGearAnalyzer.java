package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.MatchResult;

@Component
public class EngineSchematicLineGearAnalyzer {
    /*
    If a symbol (not a digit or period) exists above, below, to the right, to the left, or diagonally from any
    digit in the number, include the value of the number in the result.
     */
    public boolean isPartNumber(MatchResult match, String previousLine, String currentLine, String nextLine) {

        if (match.start() > 0) {
            if (previousLine != null && isSymbol(previousLine.charAt(match.start() - 1))) {
                return true;
            }
            if (nextLine != null && isSymbol(nextLine.charAt(match.start() - 1))) {
                return true;
            }
            if (isSymbol(currentLine.charAt(match.start() - 1))) {
                return true;
            }
        }
        if (previousLine != null && match.end() < previousLine.length()
                && isSymbol(previousLine.charAt(match.end()))) {
            return true;
        }
        if (nextLine != null && match.end() < nextLine.length()
                && isSymbol(nextLine.charAt(match.end()))) {
            return true;
        }
        if (match.end() < currentLine.length()
            && isSymbol(currentLine.charAt(match.end()))) {
            return true;
        }
        return false;
    }

    public boolean isSymbol(char c) {
        return (c < '0' || c > '9') && c != '.';
    }

    public List<Integer> getConnectedPartNumbers(MatchResult match, EngineSchematicLine line) {

//            if (partNumberAnalyzer.isPartNumber(match, previousLine, currentLine, nextLine)) {
//                String partNumberString = currentLine.substring(match.start(), match.end());
//                int partNumber = Integer.parseInt(partNumberString);
//                result += partNumber;
//            } else {
//                for (int charIndex = match.start(); charIndex < match.end(); ++charIndex) {
//                    editedCurrentLine.setCharAt(charIndex, '0');
//                }
//            }
        return List.of();
    }
}
