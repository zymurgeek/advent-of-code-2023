package org.example;

public class LineCalculator {

    private final StringFilter stringFilter;

    LineCalculator(StringFilter stringFilter) {
        this.stringFilter = stringFilter;
    }

    public int calculate(String input) {
        String digitsOnly = stringFilter.digitsOnly(input);
        if (digitsOnly.isEmpty()) {
            return 0;
        }
        String number = String.format("%c%c", digitsOnly.charAt(0), digitsOnly.charAt(digitsOnly.length()-1));
        return Integer.parseInt(number);
    }
}
