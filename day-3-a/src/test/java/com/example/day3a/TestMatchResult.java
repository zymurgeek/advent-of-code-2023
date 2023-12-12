package com.example.day3a;

import lombok.RequiredArgsConstructor;

import java.util.regex.MatchResult;

@RequiredArgsConstructor
public class TestMatchResult implements MatchResult {

    private final int start;
    private final int end;

    @Override
    public int start() {
        return start;
    }

    @Override
    public int start(int group) {
        return start;
    }

    @Override
    public int end() {
        return end;
    }

    @Override
    public int end(int group) {
        return end;
    }

    @Override
    public String group() {
        return null;
    }

    @Override
    public String group(int group) {
        return null;
    }

    @Override
    public int groupCount() {
        return 0;
    }
}
