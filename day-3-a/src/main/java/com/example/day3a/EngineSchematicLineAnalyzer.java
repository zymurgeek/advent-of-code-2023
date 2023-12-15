package com.example.day3a;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

@Component
@RequiredArgsConstructor
public class EngineSchematicLineAnalyzer {

    private final EngineSchematicLinePartNumberAnalyzer partNumberAnalyzer;

    public int sumPartNumbers(String previousLine, String currentLine, String nextLine) {
        int result = 0;
        StringBuffer editedCurrentLine = new StringBuffer(currentLine);
        /*
        - find all numbers in the current line.
        - sum each number that's next to a symbol
         */
        Scanner scanner = new Scanner(currentLine);
        scanner.useDelimiter("\\D+");
        List<MatchResult> matches = scanner.findAll("\\d+").toList();
        for (MatchResult match : matches) {
            if (partNumberAnalyzer.isPartNumber(match, previousLine, currentLine, nextLine)) {
                String partNumberString = currentLine.substring(match.start(), match.end());
                int partNumber = Integer.parseInt(partNumberString);
                result += partNumber;
            } else {
                for (int charIndex = match.start(); charIndex < match.end(); ++charIndex) {
                    editedCurrentLine.setCharAt(charIndex, '0');
                }
            }
        }
        System.out.println(editedCurrentLine);
        return result;
    }
}
