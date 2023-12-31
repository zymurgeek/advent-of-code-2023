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

	public static void main(String[] args) {
		SpringApplication.run(Day2BApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Path path = FileSystems.getDefault().getPath("src/main/resources", "input.txt");
		int sumOfGamePowers;
		try (Stream<String> lines = Files.lines(path)) {
				sumOfGamePowers = lines
						.map(parser::parseGameLine)
						.peek(System.out::println)
						.mapToInt(Game::getPower)
						.peek(System.out::println)
						.sum();
		}
		System.out.println("Sum of all game powers = " + sumOfGamePowers);
	}
}
