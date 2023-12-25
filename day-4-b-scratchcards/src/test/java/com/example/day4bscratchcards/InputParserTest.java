package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputParserTest {

    @Mock
    CardParser cardParser;

    final Card card1 = new Card(1, null, null);
    final Card card2 = new Card(2, null, null);

    @InjectMocks
    InputParser underTest;

    @Test
    void parseLines_oneLine() {
        BufferedReader reader = new BufferedReader(new StringReader("one"));
        when(cardParser.parse("one")).thenReturn(card1);

        List<Card> actual = underTest.parseLines(reader);

        assertThat(actual).containsExactly(card1);
    }

    @Test
    void parseLines_twoLines() {
        BufferedReader reader = new BufferedReader(new StringReader("one\ntwo"));
        when(cardParser.parse("one")).thenReturn(card1);
        when(cardParser.parse("two")).thenReturn(card2);

        List<Card> actual = underTest.parseLines(reader);

        assertThat(actual).containsExactly(card1, card2);
    }
}