package com.example.day4bscratchcards;

import com.example.day4bscratchcards.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Day4BScratchcardsApplication implements CommandLineRunner {

	private final InputParser inputParser;
	private final CardListAnalyzer listAnalyzer;

	public static void main(String[] args) {
		SpringApplication.run(Day4BScratchcardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String inputFileName = // "src/main/resources/input.txt";
				"src/main/resources/example-input.txt";
		BufferedReader input = new BufferedReader(new FileReader(inputFileName));
		List<Card> cardList = inputParser.parseLines(input);
		listAnalyzer.addWinningCards(cardList);
		int cards = listAnalyzer.sumCards(cardList);
		System.out.println("Total of all cards = " + cards);
	}
}
