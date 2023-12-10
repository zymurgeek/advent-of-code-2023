package com.example.day3a;

import com.example.day3a.model.Game;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Solver {

    private final InputParser parser;

    public Solver(InputParser parser) {
        this.parser = parser;
    }

    public int solve(Stream<String> input) {

        String previousLine;
        String currentLine;
        String nextLine;
		/*
		while there are lines:
			move current -> last
			move next -> current
			read a line -> next
			process current line
		move current -> last
		move next -> current
		set next to null
		process current line
		 */
        /* it's not possible to do lookahead or lookbehind with streams, so
        an alternate approach is required.
         */
        return input
                .forEachOrdered(l -> {
                    previousLine = currentLine;
                    currentLine = nextLine;
                    nextLine = l;
                    processLine(previousLine, currentLine, nextLine);
                })
                .map(parser::parseGameLine)
                .peek(System.out::println)
                .mapToInt(Game::getPower)
                .peek(System.out::println)
                .sum();
    }
}
