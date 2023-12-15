package com.example.day3b.model;

import com.example.day3b.TestMatchResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EngineSchematicLineTest {

    @Test
    void getPartNumber_noMatch() {
        EngineSchematicLine underTest = new EngineSchematicLine("", null);

        assertThat(underTest.getPartNumber(null)).isEqualTo(0);
    }

    @Test
    void getPartNumber_matches() {
        EngineSchematicLine underTest = new EngineSchematicLine("xx123yy", null);

        assertThat(underTest.getPartNumber(new TestMatchResult(2,5))).isEqualTo(123);
    }
}