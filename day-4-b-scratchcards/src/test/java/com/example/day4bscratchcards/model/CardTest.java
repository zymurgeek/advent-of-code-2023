package com.example.day4bscratchcards.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void construction() {

        Card underTest = new Card(42, Set.of(1, 2), List.of(3, 4));

        assertThat(underTest.getId()).isEqualTo(42);
        assertThat(underTest.getCount()).isEqualTo(1);
        assertThat(underTest.getWinningNumbers()).containsExactlyInAnyOrder(1, 2);
        assertThat(underTest.getPlayerNumbers()).containsExactly(3, 4);
    }

    @Test
    void addCopies_noCopies() {

        Card underTest = new Card(1, null, null);
        underTest.addCopies(0);

        assertThat(underTest.getCount()).isEqualTo(1);
    }

    @Test
    void addCopies_someCopies() {

        Card underTest = new Card(1, null, null);
        underTest.addCopies(3);

        assertThat(underTest.getCount()).isEqualTo(4);
    }
}