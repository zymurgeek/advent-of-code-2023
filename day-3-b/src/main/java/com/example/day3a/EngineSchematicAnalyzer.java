package com.example.day3a;

import com.example.day3a.model.EngineSchematicLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EngineSchematicAnalyzer {

    private final EngineSchematicLineAnalyzer lineAnalyzer;
    private final EngineSchematicLineReader lineReader;

    public int sumGearRatios(BufferedReader reader) throws IOException {

        int result = 0;
        EngineSchematicLine previousLine;
        EngineSchematicLine currentLine = null;
        EngineSchematicLine nextLine = lineReader.readLine(reader);
        do {
            previousLine = currentLine;
            currentLine = nextLine;
            nextLine = lineReader.readLine(reader);
            result += lineAnalyzer.sumGearRatios(previousLine, currentLine, nextLine);
        } while (null != nextLine);
        return result;
    }
}
