package com.example.adventofcode3.day4scratchcards;

import java.util.List;
import java.util.Set;

public record Card(int id, Set<Integer> winningNumbers, List<Integer> playerNumbers) {
}
