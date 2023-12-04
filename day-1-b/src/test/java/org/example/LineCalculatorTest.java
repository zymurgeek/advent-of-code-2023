package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LineCalculatorTest {

    @Mock
    StringFilter stringFilter;

    LineCalculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new LineCalculator(stringFilter);
    }

    @Test
    void calculate() {
        when(stringFilter.firstDigit("input")).thenReturn(3);
        when(stringFilter.lastDigit("input")).thenReturn(5);

        int actual = underTest.calculate("input");

        assertThat(actual).isEqualTo(35);
    }
}