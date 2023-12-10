package com.example.day3a;

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
public class Day3AApplication implements CommandLineRunner {

	private final Solver solver;

	public static void main(String[] args) {
		SpringApplication.run(Day3AApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Path path = FileSystems.getDefault().getPath("src/main/resources", "input.txt");
		int sumOfGamePowers;
		try (Stream<String> lines = Files.lines(path)) {
			sumOfGamePowers = solver.solve(lines);
		}
		System.out.println("Sum of all game powers = " + sumOfGamePowers);
	}
}
