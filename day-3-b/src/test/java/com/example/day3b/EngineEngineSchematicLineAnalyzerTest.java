package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EngineEngineSchematicLineAnalyzerTest {

    @Mock
    EngineSchematicLineGearAnalyzer gearAnalyzer;

    final EngineSchematicLine previousLine = new EngineSchematicLine("* previous", null);
    EngineSchematicLine currentLine = new EngineSchematicLine("* current", null);
    final EngineSchematicLine nextLine = new EngineSchematicLine("* next", null);

    EngineSchematicLineAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EngineSchematicLineAnalyzer(gearAnalyzer);
    }

    @Test
    void sumGearRatios_noGears() {
        currentLine = new EngineSchematicLine("", null);

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(0);
    }

    @Test
    void sumGearRatios_oneGear_noConnectedPartNumbers() {
        when(gearAnalyzer.getConnectedPartNumbers(0, previousLine)).thenReturn(List.of());
        when(gearAnalyzer.getConnectedPartNumbers(0, currentLine)).thenReturn(List.of());
        when(gearAnalyzer.getConnectedPartNumbers(0, nextLine)).thenReturn(List.of());

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(0);
    }

    @Test
    void sumGearRatios_oneGear_oneConnectedPartNumbers() {
        when(gearAnalyzer.getConnectedPartNumbers(0, previousLine)).thenReturn(List.of(7 ));
        when(gearAnalyzer.getConnectedPartNumbers(0, currentLine)).thenReturn(List.of());
        when(gearAnalyzer.getConnectedPartNumbers(0, nextLine)).thenReturn(List.of());

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(0);
    }

    @Test
    void sumGearRatios_oneGear_twoConnectedPartNumbers() {
        when(gearAnalyzer.getConnectedPartNumbers(0, previousLine)).thenReturn(List.of(7 ));
        when(gearAnalyzer.getConnectedPartNumbers(0, currentLine)).thenReturn(List.of(8));
        when(gearAnalyzer.getConnectedPartNumbers(0, nextLine)).thenReturn(List.of());

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(56);
    }

    @Test
    void sumGearRatios_oneGear_threeConnectedPartNumbers() {
        when(gearAnalyzer.getConnectedPartNumbers(0, previousLine)).thenReturn(List.of(7 ));
        when(gearAnalyzer.getConnectedPartNumbers(0, currentLine)).thenReturn(List.of(8));
        when(gearAnalyzer.getConnectedPartNumbers(0, nextLine)).thenReturn(List.of(9));

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(0);
    }

    @Test
    void sumGearRatios_twoGears_oneConnected() {
        currentLine = new EngineSchematicLine("**", null);
        when(gearAnalyzer.getConnectedPartNumbers(0, previousLine)).thenReturn(List.of(7 ));
        when(gearAnalyzer.getConnectedPartNumbers(0, currentLine)).thenReturn(List.of(8));
        when(gearAnalyzer.getConnectedPartNumbers(0, nextLine)).thenReturn(List.of(9));
        when(gearAnalyzer.getConnectedPartNumbers(1, previousLine)).thenReturn(List.of());
        when(gearAnalyzer.getConnectedPartNumbers(1, currentLine)).thenReturn(List.of(8));
        when(gearAnalyzer.getConnectedPartNumbers(1, nextLine)).thenReturn(List.of(9));

        assertThat(underTest.sumGearRatios(previousLine, currentLine, nextLine)).isEqualTo(72);
    }
}