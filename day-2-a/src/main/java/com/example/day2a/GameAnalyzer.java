package com.example.day2a;

import com.example.day2a.model.Game;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GameAnalyzer {
    public boolean isGamePossibleGivenCubesInBag(Game game, int redCubes, int greenCubes, int blueCubes) {
        Map<String, Integer> maximumCubeCounts = game.getMaximumCubeCounts();
        if (maximumCubeCounts.getOrDefault("red", 0) > redCubes
                || maximumCubeCounts.getOrDefault("green", 0) > greenCubes
                || maximumCubeCounts.getOrDefault("blue", 0) > blueCubes) {
            return false;
        }
        return true;
    }
}
