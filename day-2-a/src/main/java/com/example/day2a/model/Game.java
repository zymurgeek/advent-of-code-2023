package com.example.day2a.model;

import lombok.Data;

import java.util.List;

@Data
public class Game {
    private final int id;
    private List<Subset> subsets;
}
