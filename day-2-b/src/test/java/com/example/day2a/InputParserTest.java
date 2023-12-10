package com.example.day2a;

import com.example.day2a.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    InputParser underTest;

    @BeforeEach
    void setUp() {
        underTest = new InputParser();
    }

    @Test
    void parseGameLine_noSubsets() {

        Game expected = new Game(1);

        assertThat(underTest.parseGameLine("Game 1")).isEqualTo(expected);
    }

    @Test
    void parseGameLine_oneRed() {

        Game expected = new Game(2);
        expected.addDrawnCubeCount("red", 4);

        assertThat(underTest.parseGameLine("Game 2: 4 red")).isEqualTo(expected);
    }

    @Test
    void parseGameLine_threeRedOneGreenTwoBlue() {

        Game expected = new Game(3);
        expected.addDrawnCubeCount("red", 12);
        expected.addDrawnCubeCount("green", 20);
        expected.addDrawnCubeCount("blue", 30);

        assertThat(underTest.parseGameLine("Game 3: 10 red, 20 green, 30 blue; 12 red, 30 blue; 11 red")).isEqualTo(expected);
    }
}