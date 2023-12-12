package com.example.day3a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.regex.MatchResult;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EngineSchematicLinePartNumberAnalyzerTest {

    EngineSchematicLinePartNumberAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EngineSchematicLinePartNumberAnalyzer();
    }

    @Test
    void isPartNumber_noSymbols_noPreviousAndNext() {
        MatchResult match = new TestMatchResult(0,1);
        String previousLine = null;
        String currentLine = "1";
        String nextLine = null;

        assertThat(underTest.isPartNumber(match, previousLine, currentLine, nextLine)).isFalse();
    }

    @Test
    void isPartNumber_noSymbols_withPreviousAndNext() {
        MatchResult match = new TestMatchResult(0,1);
        String previousLine = ".";
        String currentLine = "1";
        String nextLine = ".";

        assertThat(underTest.isPartNumber(match, previousLine, currentLine, nextLine)).isFalse();
    }

    @Test
    void isPartNumber_symbolNorthWest() {
        MatchResult match = new TestMatchResult(1,2);
        String previousLine = "@..";
        String currentLine = ".1.";
        String nextLine = "...";

        assertThat(underTest.isPartNumber(match, previousLine, currentLine, nextLine)).isTrue();
    }

    @Test
    void isSymbol_period() {
        assertThat(underTest.isSymbol('.')).isFalse();
    }

    @Test
    void isSymbol_zero() {
        assertThat(underTest.isSymbol('0')).isFalse();
    }

    @Test
    void isSymbol_one() {
        assertThat(underTest.isSymbol('1')).isFalse();
    }

    @Test
    void isSymbol_two() {
        assertThat(underTest.isSymbol('2')).isFalse();
    }

    @Test
    void isSymbol_eight() {
        assertThat(underTest.isSymbol('8')).isFalse();
    }

    @Test
    void isSymbol_nine() {
        assertThat(underTest.isSymbol('9')).isFalse();
    }

    @Test
    void isSymbol_ampersand() {
        assertThat(underTest.isSymbol('&')).isTrue();
    }
}