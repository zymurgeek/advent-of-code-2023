package com.example.day3a;

public class LineProcessor {
    public int processLine(String previousLine, String currentLine, String nextLine) {
        String previous = (previousLine == null) ? "null" : previousLine.substring(0, 10);
        String current = (currentLine == null) ? "null" : currentLine.substring(0, 10);
        String next = (nextLine == null) ? "null" : nextLine.substring(0, 10);
        System.out.println(previous + " " + current + " " + next);
        return 0;
    }
}
