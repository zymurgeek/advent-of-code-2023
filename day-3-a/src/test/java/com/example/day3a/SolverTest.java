package com.example.day3a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SolverTest {

    @Mock
    LineProcessor lineProcessor;
    
    Solver underTest;
    
    @BeforeEach
    void setUp() {
        underTest = new Solver(lineProcessor);    
    }

    @Test
    void solve_noInput() throws IOException {
        when(lineProcessor.processLine(null, null, null)).thenReturn(2);

        int actual = underTest.solve(new BufferedReader(new StringReader("")));

       assertThat(actual).isEqualTo(2);
    }

    @Test
    void solve_oneLine() throws IOException {
        when(lineProcessor.processLine(null, "one", null)).thenReturn(5);

        int actual = underTest.solve(new BufferedReader(new StringReader("one")));

        assertThat(actual).isEqualTo(5);
    }


    @Test
    void solve_twoLines() throws IOException {
        when(lineProcessor.processLine(null, "one", "two")).thenReturn(3);
        when(lineProcessor.processLine("one", "two", "three")).thenReturn(5);
        when(lineProcessor.processLine( "two", "three", null)).thenReturn(8);

        int actual = underTest.solve(new BufferedReader(new StringReader("one\ntwo\nthree")));

        assertThat(actual).isEqualTo(16);
    }
}