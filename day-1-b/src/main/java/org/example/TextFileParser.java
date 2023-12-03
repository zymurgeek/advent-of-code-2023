package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileParser {

    private final LineCalculator lineCalculator;

    TextFileParser(LineCalculator lineCalculator) {
        this.lineCalculator = lineCalculator;
    }

    public int sumInitialAndFinalDigits(String fileName) {
        Charset charSet = StandardCharsets.US_ASCII;
        int sum = 0;
        Path file = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(file, charSet)) {
            String line;
            while((line = reader.readLine()) != null) {
                int lineValue = lineCalculator.calculate(line);
                System.out.println("line " + line + " = " + lineValue);
                sum += lineValue;
            }
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
        return sum;
    }
}
