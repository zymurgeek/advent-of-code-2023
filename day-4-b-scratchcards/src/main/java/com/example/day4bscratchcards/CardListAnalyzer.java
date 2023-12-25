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

        ListIterator<Card> listItor = cardList.listIterator();
        while (listItor.hasNext()) {
            Card thisCard = listItor.next();
            int countOfWinningNumbers = analyzer.getCountOfWinningNumbers(thisCard);
            if (countOfWinningNumbers > 0) {
                int copiesToAdd = thisCard.getCount();
                ListIterator<Card> gettingCardsItor = cardList.listIterator(listItor.nextIndex());
                do {
                    Card addCopiesToCard = gettingCardsItor.next();
                    addCopiesToCard.addCopies(copiesToAdd);
                }
                while (gettingCardsItor.hasNext());
            }
        }

    }

    //		- result = CardListAnalyzer.sumCards(list): Calculate result as the sum of the count of each card
    public int sumCards(List<Card> cardList) {
        return 0;
    }
}
