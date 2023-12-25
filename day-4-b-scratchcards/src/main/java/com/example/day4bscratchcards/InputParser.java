package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InputParser {

    private final CardParser parser;

    public List<Card> parseLines(BufferedReader input) {

        return input.lines()
                .peek(l -> System.out.print(l + " = "))
                .map(parser::parse)
                .toList();
    }
}
