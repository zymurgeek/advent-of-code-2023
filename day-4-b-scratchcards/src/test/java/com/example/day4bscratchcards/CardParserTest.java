package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class CardParserTest {

    @Test
    void parse() {

        String line = "Card 42: 3 6 9 | 2 4 8";
        Card expected = new Card(42, new TreeSet<>(Set.of(3, 6, 9)), List.of(2, 4, 8));
        CardParser underTest = new CardParser();

        assertThat(underTest.parse(line)).isEqualTo(expected);
    }
}
