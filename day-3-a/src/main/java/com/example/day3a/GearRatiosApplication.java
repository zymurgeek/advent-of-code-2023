package com.example.day3a;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
@RequiredArgsConstructor
public class GearRatiosApplication implements CommandLineRunner {

	private final EngineSchematicAnalyzer engineSchematicAnalyzer;

	public static void main(String[] args) {
		SpringApplication.run(GearRatiosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int sumOfPartNumbers;
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"))) {
			sumOfPartNumbers = engineSchematicAnalyzer.sumPartNumbers(reader);
		}
		System.out.println("Sum of all game powers = " + sumOfPartNumbers);
	}
}
