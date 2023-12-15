package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EngineSchematicLineGearAnalyzerTest {

    EngineSchematicLineGearAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EngineSchematicLineGearAnalyzer();
    }

    @Test
    void getConnectedPartNumbers_invalidGearIndex() {
        EngineSchematicLine line = new EngineSchematicLine("line", List.of(new TestMatchResult(1, 2)));

        assertThat(underTest.getConnectedPartNumbers(-1, line)).isEmpty();
    }

    @Test
    void getConnectedPartNumbers_noLine() {
        assertThat(underTest.getConnectedPartNumbers(0, null)).isEmpty();
    }

    @Test
    void getConnectedPartNumbers_noPartNumbers() {
        EngineSchematicLine lineWithoutPartNumbers = new EngineSchematicLine("line", null);

        assertThat(underTest.getConnectedPartNumbers(0, lineWithoutPartNumbers)).isEmpty();
    }

    @Test
    void getConnectedPartNumbers_oneConnectedPartNumber() {
        TestMatchResult partNumber1Match = new TestMatchResult(1, 3);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".12.",
                List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(1, lineWithOnePartNumber)).containsExactly(12);
    }

    @Test
    void getConnectedPartNumbers_twoConnectedPartNumbers() {
        TestMatchResult partNumber1Match = new TestMatchResult(1, 2);
        TestMatchResult partNumber2Match = new TestMatchResult(3, 4);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".123.",
                List.of(partNumber1Match, partNumber2Match));

        assertThat(underTest.getConnectedPartNumbers(2, lineWithOnePartNumber)).containsExactly(1, 3);
    }

    @Test
    void getConnectedPartNumbers_gearJustBeforePartNumber() {

        TestMatchResult partNumber1Match = new TestMatchResult(1, 2);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".1.", List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(0, lineWithOnePartNumber)).containsExactly(1);
    }

    @Test
    void getConnectedPartNumbers_gearInPartNumber() {

        TestMatchResult partNumber1Match = new TestMatchResult(1, 2);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".1.", List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(1, lineWithOnePartNumber)).containsExactly(1);
    }

    @Test
    void getConnectedPartNumbers_gearJustAfterPartNumber() {

        TestMatchResult partNumber1Match = new TestMatchResult(1, 2);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".1.", List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(2, lineWithOnePartNumber)).containsExactly(1);
    }

    @Test
    void getConnectedPartNumbers_gearTooFarBeforePartNumber() {

        TestMatchResult partNumber1Match = new TestMatchResult(2, 3);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine("..2.", List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(0, lineWithOnePartNumber)).isEmpty();
    }

    @Test
    void getConnectedPartNumbers_tooFarAfterPartNumber() {

        TestMatchResult partNumber1Match = new TestMatchResult(1, 2);
        EngineSchematicLine lineWithOnePartNumber = new EngineSchematicLine(".1..", List.of(partNumber1Match));

        assertThat(underTest.getConnectedPartNumbers(3, lineWithOnePartNumber)).isEmpty();
    }
}