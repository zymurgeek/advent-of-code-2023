package com.example.adventofcode3.day4scratchcards;

import org.springframework.stereotype.Component;

@Component
public class CardParser {

    public Card parse(String line) {
        return new Card(1, null, null);
    }
}
