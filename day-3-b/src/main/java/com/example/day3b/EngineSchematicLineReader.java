package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

@Component
public class EngineSchematicLineReader {

    public EngineSchematicLine readLine(BufferedReader reader) {

        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            return null;
        }
        if (null == line) {
            return null;
        }
        Scanner scanner = new Scanner(line);
        List<MatchResult> matches = scanner.findAll("\\d+").toList();
        return new EngineSchematicLine(line, matches);
    }
}
