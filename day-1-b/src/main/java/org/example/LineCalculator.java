package org.example;

public class LineCalculator {

    private final StringFilter stringFilter;

    LineCalculator(StringFilter stringFilter) {
        this.stringFilter = stringFilter;
    }

    public int calculate(String input) {
        int firstDigit = stringFilter.firstDigit(input);
        int lastDigit = stringFilter.lastDigit(input);
        return firstDigit * 10 + lastDigit;
    }
}
