package org.example;

public class StringFilter {

    public String digitsOnly(String input) {
        return input.replaceAll("[^0-9]", "");
    }
}
