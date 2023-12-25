package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardAnalyzer {

    public int getCountOfWinningNumbers(Card card) {

        if (null == card.getWinningNumbers() || null == card.getPlayerNumbers()) {
            return 0;
        }

        List<Integer> matchingNumbers = card.getPlayerNumbers().stream()
                .filter(card.getWinningNumbers()::contains)
                .toList();

        return matchingNumbers.size();
    }
}
