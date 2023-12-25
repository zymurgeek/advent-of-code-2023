package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ListIterator;

@Component
@RequiredArgsConstructor
public class CardListAnalyzer {

    private final CardAnalyzer analyzer;

    public void addWinningCards(List<Card> cardList) {

        ListIterator<Card> listIterator = cardList.listIterator();
        while (listIterator.hasNext()) {
            Card thisCard = listIterator.next();
            int countOfWinningNumbers = analyzer.getCountOfWinningNumbers(thisCard);
            if (countOfWinningNumbers > 0) {
                ListIterator<Card> extraCardsIterator = cardList.listIterator(listIterator.nextIndex());
                int copiesToAddToEachCard = thisCard.getCount();
                do {
                    Card cardToGetCopies = extraCardsIterator.next();
                    cardToGetCopies.addCopies(copiesToAddToEachCard);
                } while (--countOfWinningNumbers > 0);
            }
        }

    }

    //		- result = CardListAnalyzer.sumCards(list): Calculate result as the sum of the count of each card
    public int sumCards(List<Card> cardList) {
        return 0;
    }
}
