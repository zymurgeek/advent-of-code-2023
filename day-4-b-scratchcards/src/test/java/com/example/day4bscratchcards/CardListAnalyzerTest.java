package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardListAnalyzerTest {

    @Mock
    CardAnalyzer analyzer;

    @Mock
    Card card1;

    @Mock
    Card card2;

    @Mock
    Card card3;

    @Mock
    Card card4;

    @Mock
    Card card5;

    @Mock
    Card card6;

    @InjectMocks
    CardListAnalyzer underTest;

    @Test
    void addWinningCards_oneCard_noWinners() {

        List<Card> cardList = List.of(card1);
        when(analyzer.getCountOfWinningNumbers(card1)).thenReturn(0);

        underTest.addWinningCards(cardList);

        assertThat(cardList).containsExactly(card1);
    }

    @Test
    void addWinningCards_twoCards_noWinners() {

        List<Card> cardList = List.of(card1, card2);
        when(analyzer.getCountOfWinningNumbers(card1)).thenReturn(0);
        when(analyzer.getCountOfWinningNumbers(card2)).thenReturn(0);

        underTest.addWinningCards(cardList);

        assertThat(cardList).containsExactly(card1, card2);
    }

    @Test
    void addWinningCards_twoCards_oneWinner() {

        List<Card> cardList = List.of(card1, card2);
        when(analyzer.getCountOfWinningNumbers(card1)).thenReturn(1);
        when(card1.getCount()).thenReturn(1);
        when(analyzer.getCountOfWinningNumbers(card2)).thenReturn(0);

        underTest.addWinningCards(cardList);

        assertThat(cardList).containsExactly(card1, card2);
        verify(card2).addCopies(1);
    }

    @Test
    void addWinningCards_threeCards_twoWinners() {

        List<Card> cardList = List.of(card1, card2, card3);
        when(analyzer.getCountOfWinningNumbers(card1)).thenReturn(1);
        when(card1.getCount()).thenReturn(42);

        underTest.addWinningCards(cardList);

        assertThat(cardList).containsExactly(card1, card2, card3);
        verify(card2).addCopies(42);
        verifyNoInteractions(card3);
    }

    @Test
    void addWinningCards_example() {

        List<Card> cardList = List.of(card1, card2, card3, card4, card5, card6);
        when(card1.getCount()).thenReturn(1);
        when(card2.getCount()).thenReturn(2);
        when(card3.getCount()).thenReturn(4);
        when(card4.getCount()).thenReturn(8);
        when(analyzer.getCountOfWinningNumbers(card1)).thenReturn(4);
        when(analyzer.getCountOfWinningNumbers(card2)).thenReturn(2);
        when(analyzer.getCountOfWinningNumbers(card3)).thenReturn(2);
        when(analyzer.getCountOfWinningNumbers(card4)).thenReturn(1);
        when(analyzer.getCountOfWinningNumbers(card5)).thenReturn(0);
        when(analyzer.getCountOfWinningNumbers(card6)).thenReturn(0);

        underTest.addWinningCards(cardList);

        assertThat(cardList).containsExactly(card1, card2, card3, card4, card5, card6);
        verify(card2).addCopies(1);
        verify(card3).addCopies(1);
        verify(card3).addCopies(2);
        verify(card4).addCopies(1);
        verify(card4).addCopies(2);
        verify(card4).addCopies(4);
        verify(card5).addCopies(1);
        verify(card5).addCopies(4);
        verify(card5).addCopies(8);
        verifyNoInteractions(card6);
    }

    @Test
    void sumCards_oneCard() {

        List<Card> cardList = List.of(card1);
        when(card1.getCount()).thenReturn(7);

        int actual = underTest.sumCards(cardList);

        assertThat(actual).isEqualTo(7);
    }

    @Test
    void sumCards_threeCards() {

        List<Card> cardList = List.of(card1, card2, card3);
        when(card1.getCount()).thenReturn(2);
        when(card2.getCount()).thenReturn(3);
        when(card3.getCount()).thenReturn(5);

        int actual = underTest.sumCards(cardList);

        assertThat(actual).isEqualTo(10);
    }
}