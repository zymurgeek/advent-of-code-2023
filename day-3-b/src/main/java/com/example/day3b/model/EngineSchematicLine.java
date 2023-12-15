package com.example.day3b.model;

import java.util.List;
import java.util.regex.MatchResult;

public record EngineSchematicLine(String text, List<MatchResult> matches) {
}
