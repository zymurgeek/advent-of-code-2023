package com.example.day2a.model;

import org.junit.jupiter.api.Test;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    Game underTest = new Game(0);

    @Test
    void game_noDrawnCubes() {
        assertThat(underTest.getId()).isEqualTo(0);
        assertThat(underTest.getMaximumCubeCounts()).isEmpty();
    }

    @Test
    void game_differentId() {

        underTest = new Game(99);
        assertThat(underTest.getId()).isEqualTo(99);
        assertThat(underTest.getMaximumCubeCounts()).isEmpty();
    }

    @Test
    void addDrawnCubeCount_oneDrawnCube() {

        underTest.addDrawnCubeCount("red", 7);
        assertThat(underTest.getMaximumCubeCounts()).containsExactly(entry("red", 7));
    }

    @Test
    void addDrawnCubeCount_multipleDrawnCubes() {

        underTest.addDrawnCubeCount("red", 7);
        underTest.addDrawnCubeCount("red", 5);
        underTest.addDrawnCubeCount("green", 1);
        underTest.addDrawnCubeCount("green", 2);
        assertThat(underTest.getMaximumCubeCounts()).containsExactly(entry("red", 7), entry("green", 2));
    }

    @Test
    void power_noDrawnCubes() {
        assertThat(underTest.getPower()).isEqualTo(0);
    }

    @Test
    void power_oneDrawnCube() {

        underTest.addDrawnCubeCount("green", 17);

        assertThat(underTest.getPower()).isEqualTo(17);
    }

    @Test
    void power_multipleDrawnCubes() {

        underTest.addDrawnCubeCount("red", 2);
        underTest.addDrawnCubeCount("green", 3);
        underTest.addDrawnCubeCount("blue", 5);

        assertThat(underTest.getPower()).isEqualTo(30);
    }
}