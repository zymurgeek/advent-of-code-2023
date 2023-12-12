package com.example.day3a;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

@Component
public class EngineSchematicLineAnalyzer {
    public int sumPartNumbers(String previousLine, String currentLine, String nextLine) {
        int result = 0;
        /*
        find the first number in the current line.  Get start and end index.
        If a symbol (not a digit or period) exists above, below, to the right, to the left, or diagonally from any
        digit in the number, include the value of the number in the result.
         */
        Scanner scanner = new Scanner(currentLine);
        scanner.useDelimiter("\\D+");
        List<MatchResult> matches = scanner.findAll("\\d+").toList();
        for (MatchResult match : matches) {
            String partNumberString = currentLine.substring(match.start(), match.end());
            int partNumber = Integer.parseInt(partNumberString);
            result += partNumber;
        }
        return result;
    }
}
