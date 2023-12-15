package com.example.day3a;

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
class EngineSchematicLineAnalyzerTest {

    @Mock
    EngineSchematicLinePartNumberAnalyzer partNumberAnalyzer;

    EngineSchematicLineAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EngineSchematicLineAnalyzer(partNumberAnalyzer);
    }

    @Test
    void sumPartNumbers_noPartNumbers() {
        assertThat(underTest.sumPartNumbers("a", "b", "c")).isEqualTo(0);
    }

    @Test
    void sumPartNumbers_onePartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b"), eq("c"))).thenReturn(true);

        assertThat(underTest.sumPartNumbers("a", "b123b", "c")).isEqualTo(123);
    }

    @Test
    void sumPartNumbers_oneNonPartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b"), eq("c"))).thenReturn(false);

        assertThat(underTest.sumPartNumbers("a", "b123b", "c")).isEqualTo(0);
    }

    @Test
    void sumPartNumbers_twoNumbers_secondIsPartNumber() {
        when(partNumberAnalyzer.isPartNumber(any(), eq("a"), eq("b123b456b"), eq("c")))
                .thenReturn(false).thenReturn(true);

        assertThat(underTest.sumPartNumbers("a", "b123b456b", "c")).isEqualTo(456);
    }
}