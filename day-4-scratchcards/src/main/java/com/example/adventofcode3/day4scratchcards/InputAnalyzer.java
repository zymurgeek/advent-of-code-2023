package com.example.adventofcode3.day4scratchcards;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
@RequiredArgsConstructor
public class InputAnalyzer {

    private final CardParser parser;
    private final CardAnalyzer analyzer;

    public int sumPointsOfCards(BufferedReader input) {

        return input.lines()
                .peek(l -> System.out.print(l + " = "))
                .map(parser::parse)
                .mapToInt(analyzer::points)
                .peek(System.out::println)
                .sum();
    }
}
