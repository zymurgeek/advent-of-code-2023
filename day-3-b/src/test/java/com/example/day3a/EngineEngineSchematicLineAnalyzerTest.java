package com.example.day3a;

import com.example.day3a.model.EngineSchematicLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EngineEngineSchematicLineAnalyzerTest {

    @Mock
    EngineSchematicLinePartNumberAnalyzer partNumberAnalyzer;

    EngineSchematicLineAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EngineSchematicLineAnalyzer(partNumberAnalyzer);
    }

    @Test
    void sumPartNumbers_noPartNumbers() {
        EngineSchematicLine previousLine = new EngineSchematicLine();
        EngineSchematicLine currentLine = new EngineSchematicLine();
        EngineSchematicLine nextLine = new EngineSchematicLine();
        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(0);
    }
/*
    @Test
    void sumPartNumbers_onePartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b"), eq("c"))).thenReturn(true);

        assertThat(underTest.sumGearRatios("a", "b123b", "c")).isEqualTo(123);
    }

    @Test
    void sumPartNumbers_oneNonPartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b"), eq("c"))).thenReturn(false);

        assertThat(underTest.sumGearRatios("a", "b123b", "c")).isEqualTo(0);
    }

    @Test
    void sumPartNumbers_twoNumbers_secondIsPartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b456b"), eq("c")))
                .thenReturn(false).thenReturn(true);

        assertThat(underTest.sumGearRatios("a", "b123b456b", "c")).isEqualTo(456);
    }
 */
}