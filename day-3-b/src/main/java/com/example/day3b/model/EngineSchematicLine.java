package com.example.day3b.model;

import java.util.List;
import java.util.regex.MatchResult;

public record EngineSchematicLine(String text, List<MatchResult> partNumberMatches) {

    int getPartNumber(MatchResult partNumberMatch) {
        if (null == partNumberMatch) {
            return 0;
        }
        return Integer.parseInt(text.substring(partNumberMatch.start(), partNumberMatch.end()));
    }
}
