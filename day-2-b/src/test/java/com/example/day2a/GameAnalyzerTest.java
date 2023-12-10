package com.example.day2a;

import com.example.day2a.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameAnalyzerTest {

    private GameAnalyzer underTest;

    @BeforeEach
    void setUp() {
        underTest = new GameAnalyzer();
    }

    @Test
    void isGamePossibleGivenCubesInBag_noCounts() {

        Game game = new Game(1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 0, 0)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Red_game2Red() {

        Game game = new Game(1);
        game.addDrawnCubeCount("red", 2);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 1, 0, 0)).isFalse();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag2Red_game1Red() {

        Game game = new Game(1);
        game.addDrawnCubeCount("red", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 2, 0, 0)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Red_game1Red() {

        Game game = new Game(1);
        game.addDrawnCubeCount("red", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 1, 0, 0)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Green_game2Green() {

        Game game = new Game(1);
        game.addDrawnCubeCount("green", 2);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 1, 0)).isFalse();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag2Green_game1Green() {

        Game game = new Game(1);
        game.addDrawnCubeCount("green", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 2, 0)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Green_game1Green() {

        Game game = new Game(1);
        game.addDrawnCubeCount("green", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 1, 0)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Blue_game2Blue() {

        Game game = new Game(1);
        game.addDrawnCubeCount("blue", 2);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 0, 1)).isFalse();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag2Blue_game1Blue() {

        Game game = new Game(1);
        game.addDrawnCubeCount("blue", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 0, 2)).isTrue();
    }

    @Test
    void isGamePossibleGivenCubesInBag_bag1Blue_game1Blue() {

        Game game = new Game(1);
        game.addDrawnCubeCount("blue", 1);

        assertThat(underTest.isGamePossibleGivenCubesInBag(game, 0, 0, 1)).isTrue();
    }
}