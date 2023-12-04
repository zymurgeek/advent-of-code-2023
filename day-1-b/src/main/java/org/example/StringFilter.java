package org.example;

import java.util.Map;

public class StringFilter {

    Map<String, Integer> values = Map.ofEntries(
            Map.entry("0", 0),
            Map.entry("1", 1),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("zero", 0),
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5),
            Map.entry("six", 6),
            Map.entry("seven", 7),
            Map.entry("eight", 8),
            Map.entry("nine", 9)
    );

    public int firstDigit(String input) {
        for (int charIndex = 0; charIndex < input.length(); ++charIndex) {
            Integer result = valueOfStringStartingAt(input, charIndex);
            if (null != result) {
                return result;
            }
        }
        return 0;
    }

    public int lastDigit(String input) {
        for (int charIndex = input.length() - 1; charIndex >= 0; --charIndex) {
            Integer result = valueOfStringStartingAt(input, charIndex);
            if (null != result) {
                return result;
            }
        }
        return 0;
    }

    private Integer valueOfStringStartingAt(String input, int startingIndex) {
        Integer value;
        String subString;
        for (String key: values.keySet()) {
            try {
                subString = input.substring(startingIndex, startingIndex + key.length());
            } catch (StringIndexOutOfBoundsException x) {
                continue;
            }
            value = values.get(subString);
            if (null != value) {
                return value;
            }
        }
        return null;
    }
}
