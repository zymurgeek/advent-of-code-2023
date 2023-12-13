package com.example.day3a;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class EngineSchematicAnalyzer {

    private final EngineSchematicLineAnalyzer engineSchematicLineAnalyzer;

    public EngineSchematicAnalyzer(EngineSchematicLineAnalyzer engineSchematicLineAnalyzer) {
        this.engineSchematicLineAnalyzer = engineSchematicLineAnalyzer;
    }

    public int sumGearRatios(BufferedReader reader) throws IOException {

        int result = 0;
        String previousLine;
        String currentLine = null;
        String nextLine = reader.readLine();
        do {
            previousLine = currentLine;
            currentLine = nextLine;
            nextLine = reader.readLine();
            result += engineSchematicLineAnalyzer.sumPartNumbers(previousLine, currentLine, nextLine);
        } while (null != nextLine);
        return result;
    }
}
