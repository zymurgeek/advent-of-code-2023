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
    void calculate_noDigits() {
        when(stringFilter.digitsOnly("input")).thenReturn("");

        int actual = underTest.calculate("input");

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void calculate_oneDigit() {
        when(stringFilter.digitsOnly("input")).thenReturn("3");

        int actual = underTest.calculate("input");

        assertThat(actual).isEqualTo(33);
    }

    @Test
    void calculate_twoDigits() {
        when(stringFilter.digitsOnly("input")).thenReturn("78");

        int actual = underTest.calculate("input");

        assertThat(actual).isEqualTo(78);
    }

    @Test
    void calculate_threeDigits() {
        when(stringFilter.digitsOnly("input")).thenReturn("456");

        int actual = underTest.calculate("input");

        assertThat(actual).isEqualTo(46);
    }
}