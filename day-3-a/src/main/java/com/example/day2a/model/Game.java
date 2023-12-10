package com.example.day2a.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Game {

    private final int id;
    private Map<String, Integer> maximumCubeCounts = new HashMap<>();

    public void addDrawnCubeCount(String color, int count) {

        Integer maximumCubeCount = maximumCubeCounts.getOrDefault(color, 0);
        if (count > maximumCubeCount) {
            maximumCubeCounts.put(color, count);
        }
    }

    public int getPower() {

        if (maximumCubeCounts.isEmpty()) {
            return 0;
        }

        int power = 1;
        for (int maximumCubeCount : maximumCubeCounts.values()) {
            power *= maximumCubeCount;
        }
        return power;
    }
}