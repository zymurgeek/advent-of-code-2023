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
        String previousLine;
        String currentLine = null;
        String nextLine = reader.readLine();
        do {
            previousLine = currentLine;
            currentLine = nextLine;
            nextLine = reader.readLine();
            result += lineProcessor.processLine(previousLine, currentLine, nextLine);
        } while (null != nextLine);
        return result;
    }
}
