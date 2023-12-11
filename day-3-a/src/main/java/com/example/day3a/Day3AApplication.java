package com.example.day3a;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
@RequiredArgsConstructor
public class Day3AApplication implements CommandLineRunner {

	private final Solver solver;

	public static void main(String[] args) {
		SpringApplication.run(Day3AApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int sumOfPartNumbers;
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"))) {
			sumOfPartNumbers = solver.solve(reader);
		}
		System.out.println("Sum of all game powers = " + sumOfPartNumbers);
	}
}
