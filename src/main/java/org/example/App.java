package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StringFilter stringFilter = new StringFilter();
        LineCalculator lineCalculator = new LineCalculator(stringFilter);
        TextFileParser parser = new TextFileParser(lineCalculator);
        String fileName = "src/main/resources/input.txt";

        int sum = parser.sumInitialAndFinalDigits(fileName);

        System.out.println("Sum of " + fileName + " = " + sum);
    }
}
