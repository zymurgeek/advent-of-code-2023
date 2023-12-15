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

        if (previousLine != null) {
            // Northwest
            if (match.start() > 0 && isSymbol(previousLine.charAt(match.start() - 1))) {
                return true;
            }
            // North
            for (int charIndex = match.start(); charIndex < match.end(); ++charIndex) {
                if (isSymbol(previousLine.charAt(charIndex))) {
                    return true;
                }
            }
            // Northeast
            if (match.end() < previousLine.length() && isSymbol(previousLine.charAt(match.end()))) {
                return true;
            }
        }
        // West
        if (match.start() > 0 && isSymbol(currentLine.charAt(match.start() - 1))) {
            return true;
        }
        // East
        if (match.end() < currentLine.length() && isSymbol(currentLine.charAt(match.end()))) {
            return true;
        }
        if (nextLine != null) {
            // Southwest
            if (match.start() > 0 && isSymbol(nextLine.charAt(match.start() - 1))) {
                return true;
            }
            // South
            for (int charIndex = match.start(); charIndex < match.end(); ++charIndex) {
                if (isSymbol(nextLine.charAt(charIndex))) {
                    return true;
                }
            }
            // Southeast
            if (match.end() < nextLine.length() && isSymbol(nextLine.charAt(match.end()))) {
                return true;
            }
        }
        return false;
    }

    public boolean isSymbol(char c) {
        return (c < '0' || c > '9') && c != '.';
    }
}
