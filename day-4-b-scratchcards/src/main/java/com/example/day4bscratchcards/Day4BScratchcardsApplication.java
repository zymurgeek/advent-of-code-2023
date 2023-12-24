package com.example.day4bscratchcards;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
public class Day4BScratchcardsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day4BScratchcardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BufferedReader input = new BufferedReader(new FileReader("src/main/resources/input.txt"));
		/*
		- List = CardReader.read(input): Read all cards and add them to a sorted list.
			- each card will have a count of 1.
		- CardListAnalyzer.addWinningCards(list): Go through the list of cards and for each:
			- Calculate count of winning numbers
			- for each "winning count" cards following the current one, increase that card's count by current card count
		- result = CardListAnalyzer.sumCards(list): Calculate result as the sum of the count of each card
		 */
		int cards = 0;
		System.out.println("Total of all cards = " + cards);
	}
}
