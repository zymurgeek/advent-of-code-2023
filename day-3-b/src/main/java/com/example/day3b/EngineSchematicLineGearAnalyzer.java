package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;

@Component
public class EngineSchematicLineGearAnalyzer {

    public List<Integer> getConnectedPartNumbers(int gearIndex, EngineSchematicLine line) {

        List<Integer> result = new ArrayList<>();
        if (null == line || null == line.partNumberMatches()) {
            return result;
        }
        for (MatchResult partNumberMatch : line.partNumberMatches()) {
            if (gearIndex >= partNumberMatch.start() - 1 && gearIndex <= partNumberMatch.end()) {
                result.add(line.getPartNumber(partNumberMatch));
            }
        }
        return result;
    }
}
