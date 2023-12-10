package com.example.day2a;

import com.example.day2a.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class Day2BApplication implements CommandLineRunner {

	private final InputParser parser;
	private final GameAnalyzer analyzer;

	public static void main(String[] args) {
		SpringApplication.run(Day2BApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Path path = FileSystems.getDefault().getPath("src/main/resources", "input.txt");
		int sumOfPossibleGameIds;
		try (Stream<String> lines = Files.lines(path)) {
				sumOfPossibleGameIds = lines
						.map(parser::parseGameLine)
						.peek(System.out::println)
						.filter(g -> analyzer.isGamePossibleGivenCubesInBag(g, 12, 13, 14))
						.mapToInt(Game::getId)
						.sum();
		}
		System.out.println("Sum of all possible game IDs = " + sumOfPossibleGameIds);
	}
}
