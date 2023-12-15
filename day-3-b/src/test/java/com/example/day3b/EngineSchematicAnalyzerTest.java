package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EngineSchematicAnalyzerTest {

    @Mock
    EngineSchematicLineReader lineReader;

    @Mock
    EngineSchematicLineAnalyzer lineAnalyzer;

    @Mock
    BufferedReader reader;

    @InjectMocks
    EngineSchematicAnalyzer underTest;

    @Test
    void sumGearRatios_noInput() throws IOException {
        when(lineReader.readLine(reader)).thenReturn(null);
        when(lineAnalyzer.sumGearRatios(null, null, null)).thenReturn(2);

        int actual = underTest.sumGearRatios(reader);

       assertThat(actual).isEqualTo(2);
    }

    @Test
    void sumGearRatios_oneLine() throws IOException {
        EngineSchematicLine firstLine = new EngineSchematicLine();
        when(lineReader.readLine(reader))
                .thenReturn(firstLine)
                .thenReturn(null);
        when(lineAnalyzer.sumGearRatios(null, firstLine, null)).thenReturn(5);

        int actual = underTest.sumGearRatios(reader);

        assertThat(actual).isEqualTo(5);
    }

    @Test
    void sumGearRatios_threeLines() throws IOException {
        EngineSchematicLine firstLine = new EngineSchematicLine();
        EngineSchematicLine secondLine = new EngineSchematicLine();
        EngineSchematicLine thirdLine = new EngineSchematicLine();
        when(lineReader.readLine(reader))
                .thenReturn(firstLine)
                .thenReturn(secondLine)
                .thenReturn(thirdLine)
                .thenReturn(null);
        when(lineAnalyzer.sumGearRatios(null, firstLine, secondLine)).thenReturn(1);
        when(lineAnalyzer.sumGearRatios(firstLine, secondLine, thirdLine)).thenReturn(2);
        when(lineAnalyzer.sumGearRatios(secondLine, thirdLine, null)).thenReturn(3);

        int actual = underTest.sumGearRatios(reader);

        assertThat(actual).isEqualTo(6);
    }
}