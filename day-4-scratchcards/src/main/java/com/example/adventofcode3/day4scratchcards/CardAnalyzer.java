package com.example.adventofcode3.day4scratchcards;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardAnalyzer {
    public int points(Card card) {

        if (null == card.winningNumbers() || null == card.playerNumbers()) {
            return 0;
        }

        List<Integer> matchingNumbers = card.playerNumbers().stream()
                .filter(card.winningNumbers()::contains)
                .toList();

        int countOfMatches = matchingNumbers.size();
        if (0 == countOfMatches) {
            return 0;
        }

        int points = 1;
        for (int matchNumber = 1; matchNumber < countOfMatches; ++matchNumber) {
            points *= 2;
        }

        return points;
    }
}
