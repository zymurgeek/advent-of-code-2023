package com.example.day2a.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subset {
    private int redCount;
    private int greenCount;
    private int blueCount;
}
