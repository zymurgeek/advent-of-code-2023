package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringFilterTest {

    StringFilter underTest = new StringFilter();

    @Test
    void digitsOnly_empty() {
        assertThat(underTest.digitsOnly("")).isEmpty();
    }

    @Test
    void digitsOnly_noDigits() {
        assertThat(underTest.digitsOnly("abcdefh")).isEmpty();
    }

    @Test
    void digitsOnly_oneDigit() {
        assertThat(underTest.digitsOnly("abc3flk")).isEqualTo("3");
    }

    @Test
    void digitsOnly_twoDigits() {
        assertThat(underTest.digitsOnly("abd1def2ghi")).isEqualTo("12");
    }

    @Test
    void digitsOnly_threeDigits() {
        assertThat(underTest.digitsOnly("abc 4 def 5 ghi 6 jkl")).isEqualTo("456");
    }
}