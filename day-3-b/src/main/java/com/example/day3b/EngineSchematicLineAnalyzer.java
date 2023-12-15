package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

@Component
@RequiredArgsConstructor
public class EngineSchematicLineAnalyzer {

    private final EngineSchematicLineGearAnalyzer gearAnalyzer;

    public int sumGearRatios(EngineSchematicLine previousLine, EngineSchematicLine currentLine, EngineSchematicLine nextLine) {
        int result = 0;
        System.out.print(currentLine.text() + " ");

        // look for gears in current line
        Scanner scanner = new Scanner(currentLine.text());
        List<MatchResult> matches = scanner.findAll("\\*").toList();

        // for each gear found
        for (MatchResult match : matches) {
            System.out.print("*");

            // find all part numbers in each of the lines that are connected to the gear
            List<Integer> connectedPartNumbers = new ArrayList<>();
            connectedPartNumbers.addAll(gearAnalyzer.getConnectedPartNumbers(match, previousLine));
            connectedPartNumbers.addAll(gearAnalyzer.getConnectedPartNumbers(match, currentLine));
            connectedPartNumbers.addAll(gearAnalyzer.getConnectedPartNumbers(match, nextLine));

            if (connectedPartNumbers.size() == 2) {
                // If there are exactly two connected part numbers, add their product to the result
                Integer first = connectedPartNumbers.get(0);
                Integer second = connectedPartNumbers.get(1);
                int ratio = first * second;
                result +=  first * second;
                System.out.print("=" + ratio + " ");
            } else {
                System.out.print("(" + connectedPartNumbers.size() + ") ");
            }
        }
        System.out.println("sum=" + result);
        return result;
    }
}
