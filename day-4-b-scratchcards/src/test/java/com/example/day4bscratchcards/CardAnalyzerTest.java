package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardAnalyzerTest {

    @Mock
    Card card;

    final CardAnalyzer underTest = new CardAnalyzer();

    @Test
    void getCountOfWinningNumbers_noNumbers() {

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(0);
    }

    @Test
    void getCountOfWinningNumbers_onlyWinningNumbers() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(0);
    }

    // There is no test for only player numbers because lack of winning numbers short circuits that check

    @Test
    void getCountOfWinningNumbers_noMatches() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));
        when(card.getPlayerNumbers()).thenReturn(List.of(4, 5, 6));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(0);
    }

    @Test
    void getCountOfWinningNumbers_oneMatch() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));
        when(card.getPlayerNumbers()).thenReturn(List.of(4, 2, 6));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(1);
    }

    @Test
    void getCountOfWinningNumbers_twoMatches() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));
        when(card.getPlayerNumbers()).thenReturn(List.of(4, 2, 1));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(2);
    }

    @Test
    void getCountOfWinningNumbers_threeMatches() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));
        when(card.getPlayerNumbers()).thenReturn(List.of(4, 2, 1, 3));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(3);
    }

    @Test
    void getCountOfWinningNumbers_fourMatches() {

        when(card.getWinningNumbers()).thenReturn(Set.of(1, 2, 3));
        when(card.getPlayerNumbers()).thenReturn(List.of(4, 2, 1, 3, 3));

        assertThat(underTest.getCountOfWinningNumbers(card)).isEqualTo(4);
    }
}