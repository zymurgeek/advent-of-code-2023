package com.example.day2a;

import com.example.day2a.model.Game;
import com.example.day2a.model.Subset;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Day2AApplication implements CommandLineRunner {

	private final InputParser parser;
	private final GamesAnalyzer analyzer;

	public static void main(String[] args) {
		SpringApplication.run(Day2AApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Game> games = parser.parse("src/main/resources/input.txt");
		int sumOfPossibleGameIds = analyzer.sumIdsOfPossibleGamesWithCubesInBag(games, new Subset(12, 13, 14));

		System.out.println("Sum of all possible game IDs = " + sumOfPossibleGameIds);
	}
}
