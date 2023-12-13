package com.example.day3a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EngineSchematicAnalyzerTest {

    @Mock
    EngineSchematicLineReader lineReader;

    @Mock
    EngineSchematicLineAnalyzer lineAnalyzer;

    @InjectMocks
    EngineSchematicAnalyzer underTest;

    // TODO:  Update tests
    /*
    @Test
    void sumGearRatios_noInput() throws IOException {
        when(lineAnalyzer.sumGearRatios(null, null, null)).thenReturn(2);

        int actual = underTest.sumGearRatios(new BufferedReader(new StringReader("")));

       assertThat(actual).isEqualTo(2);
    }

    @Test
    void sumGearRatios_oneLine() throws IOException {
        when(lineAnalyzer.sumGearRatios(null, "one", null)).thenReturn(5);

        int actual = underTest.sumGearRatios(new BufferedReader(new StringReader("one")));

        assertThat(actual).isEqualTo(5);
    }


    @Test
    void sumGearRatios_twoLines() throws IOException {
        when(lineAnalyzer.sumGearRatios(null, "one", "two")).thenReturn(3);
        when(lineAnalyzer.sumGearRatios("one", "two", "three")).thenReturn(5);
        when(lineAnalyzer.sumGearRatios( "two", "three", null)).thenReturn(8);

        int actual = underTest.sumGearRatios(new BufferedReader(new StringReader("one\ntwo\nthree")));

        assertThat(actual).isEqualTo(16);
    }
     */
}