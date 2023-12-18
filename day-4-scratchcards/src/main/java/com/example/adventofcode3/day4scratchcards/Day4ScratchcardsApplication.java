package com.example.adventofcode3.day4scratchcards;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
@RequiredArgsConstructor
public class Day4ScratchcardsApplication implements CommandLineRunner {

	private final InputAnalyzer inputAnalyzer;

	public static void main(String[] args) {
		SpringApplication.run(Day4ScratchcardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BufferedReader input = new BufferedReader(new FileReader("src/main/resources/input.txt"));
		int points = inputAnalyzer.sumPointsOfCards(input);
		System.out.println("Sum of each card's points = " + points);
	}
}
