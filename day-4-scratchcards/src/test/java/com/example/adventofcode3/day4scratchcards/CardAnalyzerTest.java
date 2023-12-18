package com.example.adventofcode3.day4scratchcards;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CardAnalyzerTest {

    final CardAnalyzer underTest = new CardAnalyzer();

    @Test
    void points_noNumbers() {

        Card card = new Card(1, null, null);

        assertThat(underTest.points(card)).isEqualTo(0);
    }

    @Test
    void points_onlyWinningNumbers() {

        Card card = new Card(1, Set.of(1, 2, 3), null);

        assertThat(underTest.points(card)).isEqualTo(0);
    }

    @Test
    void points_onlyPlayerNumbers() {

        Card card = new Card(1, null, List.of(1, 2, 3));

        assertThat(underTest.points(card)).isEqualTo(0);
    }

    @Test
    void points_noMatches() {

        Card card = new Card(1, Set.of(1, 2, 3), List.of(4, 5, 6));

        assertThat(underTest.points(card)).isEqualTo(0);
    }

    @Test
    void points_oneMatch() {

        Card card = new Card(1, Set.of(1, 2, 3), List.of(4, 2, 6));

        assertThat(underTest.points(card)).isEqualTo(1);
    }

    @Test
    void points_twoMatches() {

        Card card = new Card(1, Set.of(1, 2, 3), List.of(4, 2, 1));

        assertThat(underTest.points(card)).isEqualTo(2);
    }

    @Test
    void points_threeMatches() {

        Card card = new Card(1, Set.of(1, 2, 3), List.of(4, 2, 1, 3));

        assertThat(underTest.points(card)).isEqualTo(4);
    }

    @Test
    void points_fourMatches() {

        Card card = new Card(1, Set.of(1, 2, 3), List.of(4, 2, 1, 3, 3));

        assertThat(underTest.points(card)).isEqualTo(8);
    }
}