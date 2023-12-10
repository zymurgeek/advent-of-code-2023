package com.example.day3a;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class Solver {

    private final LineProcessor lineProcessor;

    public Solver(LineProcessor lineProcessor) {
        this.lineProcessor = lineProcessor;
    }

    public int solve(BufferedReader reader) throws IOException {

        int result = 0;
        String previousLine = null;
        String currentLine = null;
        String nextLine = reader.readLine();
        String line;
        while (null != (line = reader.readLine())) {
            previousLine = currentLine;
            currentLine = nextLine;
            nextLine = line;
            result += lineProcessor.processLine(previousLine, currentLine, nextLine);
        }
        previousLine = currentLine;
        currentLine = nextLine;
        result += lineProcessor.processLine(previousLine, currentLine, null);
        return result;
    }
}
