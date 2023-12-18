package com.example.adventofcode3.day4scratchcards;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

@Component
public class CardParser {

    public Card parse(String line) {

        // Split line on : into card identification and numbers
        String[] idAndNumbersText = line.split(":");
        String idText = idAndNumbersText[0];
        String numbersText = idAndNumbersText[1];

        // Scan card identification for ID
        Scanner scanner = new Scanner(idText);
        scanner.next();
        int id = scanner.nextInt();

        // Split numbers on | into winningNumbersText and playerNumbersText
        String[] winningAndPlayerNumbersText = numbersText.split("\\|");
        String winningNumbersText = winningAndPlayerNumbersText[0];
        String playerNumbersText = winningAndPlayerNumbersText[1];

        // Scan winningNumberText into winningNumbers
        scanner = new Scanner(winningNumbersText);
        Set<Integer> winningNumbers = new TreeSet<>();
        while (scanner.hasNextInt()) {
            winningNumbers.add(scanner.nextInt());
        }

        // Scan playerNumbersText into playerNumbers
        scanner = new Scanner(playerNumbersText);
        List<Integer> playerNumbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            playerNumbers.add(scanner.nextInt());
        }

        return new Card(id, winningNumbers, playerNumbers);
    }
}
