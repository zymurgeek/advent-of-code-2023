package com.example.day2a;

import com.example.day2a.model.Game;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputParser {
    public Game parseGameLine(String gameLine) {

        Scanner s = new Scanner(gameLine);
        s.useDelimiter("[^\\p{Alnum}]+");
        s.next(); // "Game"
        int gameId = s.nextInt();
        Game game = new Game(gameId);
        while (s.hasNext()) {
            int count = s.nextInt();
            String color = s.next();
            game.addDrawnCubeCount(color, count);
        }
        return game;
    }
}
