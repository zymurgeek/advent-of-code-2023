package com.example.adventofcode3.day4scratchcards;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputAnalyzerTest {

    @Mock
    CardParser parser;

    @Mock
    CardAnalyzer analyzer;

    @Mock
    Card firstCard;

    @Mock
    Card secondCard;

    @InjectMocks
    InputAnalyzer underTest;

    @Test
    void sumPointsOfCards_noLines() {
        BufferedReader input = new BufferedReader(new StringReader(""));

        assertThat(underTest.sumPointsOfCards(input)).isEqualTo(0);
    }

    @Test
    void sumPointsOfCards_oneLine() {
        BufferedReader input = new BufferedReader(new StringReader("first"));
        when(parser.parse("first")).thenReturn(firstCard);
        when(analyzer.points(firstCard)).thenReturn(1);

        assertThat(underTest.sumPointsOfCards(input)).isEqualTo(1);
    }

    @Test
    void sumPointsOfCards_twoLines() {
        BufferedReader input = new BufferedReader(new StringReader("first\nsecond"));
        when(parser.parse("first")).thenReturn(firstCard);
        when(parser.parse("second")).thenReturn(secondCard);
        when(analyzer.points(firstCard)).thenReturn(1);
        when(analyzer.points(secondCard)).thenReturn(2);

        assertThat(underTest.sumPointsOfCards(input)).isEqualTo(3);
    }
}