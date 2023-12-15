package com.example.day3b;

import com.example.day3b.model.EngineSchematicLine;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class EngineSchematicLineReaderTest {

    final EngineSchematicLineReader underTest = new EngineSchematicLineReader();

    @Test
    void readLine_noInput() {

        String lineText = "";
        BufferedReader line = new BufferedReader(new StringReader(lineText));

        EngineSchematicLine actual = underTest.readLine(line);

        assertThat(actual).isNull();
    }

    @Test
    void readLine_onePartNumber() {
        String lineText = "99";
        BufferedReader line = new BufferedReader(new StringReader(lineText));

        EngineSchematicLine actual = underTest.readLine(line);

        assertThat(actual.text()).isEqualTo(lineText);
        assertThat(actual.matches()).map(m -> tuple(m.start(), m.end()))
                .containsExactly(tuple(0,2));
    }

    @Test
    void readLine_twoPartNumbers() {
        String lineText = ".10.20.";
        BufferedReader line = new BufferedReader(new StringReader(lineText));

        EngineSchematicLine actual = underTest.readLine(line);

        assertThat(actual.text()).isEqualTo(lineText);
        assertThat(actual.matches()).map(m -> tuple(m.start(), m.end()))
                .containsExactly(tuple(1,3), tuple(4,6));
    }
}