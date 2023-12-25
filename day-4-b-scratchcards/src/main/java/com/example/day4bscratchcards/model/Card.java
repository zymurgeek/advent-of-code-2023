package com.example.day4bscratchcards.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Card {

    private int id;
    private int count;
    private Set<Integer> winningNumbers;
    private List<Integer> playerNumbers;

    public Card(int id, Set<Integer> winningNumbers, List<Integer> playerNumbers) {
        this.id = id;
        this.count = 1;
        this.winningNumbers = winningNumbers;
        this.playerNumbers = playerNumbers;
    }

    public void addCopies(int numberOfCards) {

    }
}
