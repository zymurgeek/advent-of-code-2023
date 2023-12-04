package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringFilterTest {

    StringFilter underTest = new StringFilter();

    @Test
    void firstDigit_empty() {
        assertThat(underTest.firstDigit("")).isEqualTo(0);
    }

    @Test
    void firstDigit_noDigits() {
        assertThat(underTest.firstDigit("abcdefh")).isEqualTo(0);
    }

    @Test
    void firstDigit_0() {
        assertThat(underTest.firstDigit("0")).isEqualTo(0);
    }

    @Test
    void firstDigit_1() {
        assertThat(underTest.firstDigit("1")).isEqualTo(1);
    }

    @Test
    void firstDigit_2() {
        assertThat(underTest.firstDigit("2")).isEqualTo(2);
    }

    @Test
    void firstDigit_3() {
        assertThat(underTest.firstDigit("3")).isEqualTo(3);
    }

    @Test
    void firstDigit_4() {
        assertThat(underTest.firstDigit("4")).isEqualTo(4);
    }

    @Test
    void firstDigit_5() {
        assertThat(underTest.firstDigit("5")).isEqualTo(5);
    }

    @Test
    void firstDigit_6() {
        assertThat(underTest.firstDigit("6")).isEqualTo(6);
    }

    @Test
    void firstDigit_7() {
        assertThat(underTest.firstDigit("7")).isEqualTo(7);
    }

    @Test
    void firstDigit_8() {
        assertThat(underTest.firstDigit("8")).isEqualTo(8);
    }

    @Test
    void firstDigit_9() {
        assertThat(underTest.firstDigit("9")).isEqualTo(9);
    }

    @Test
    void firstDigit_3AtStart() {
        assertThat(underTest.firstDigit("3flk")).isEqualTo(3);
    }

    @Test
    void firstDigit_3InMiddle() {
        assertThat(underTest.firstDigit("abc3flk")).isEqualTo(3);
    }

    @Test
    void firstDigit_3AtEnd() {
        assertThat(underTest.firstDigit("abc3")).isEqualTo(3);
    }

    @Test
    void firstDigit_zero() {
        assertThat(underTest.firstDigit("zero")).isEqualTo(0);
    }

    @Test
    void firstDigit_one() {
        assertThat(underTest.firstDigit("one")).isEqualTo(1);
    }

    @Test
    void firstDigit_two() {
        assertThat(underTest.firstDigit("two")).isEqualTo(2);
    }

    @Test
    void firstDigit_three() {
        assertThat(underTest.firstDigit("three")).isEqualTo(3);
    }

    @Test
    void firstDigit_four() {
        assertThat(underTest.firstDigit("four")).isEqualTo(4);
    }

    @Test
    void firstDigit_five() {
        assertThat(underTest.firstDigit("five")).isEqualTo(5);
    }


    @Test
    void firstDigit_six() {
        assertThat(underTest.firstDigit("six")).isEqualTo(6);
    }


    @Test
    void firstDigit_seven() {
        assertThat(underTest.firstDigit("seven")).isEqualTo(7);
    }

    @Test
    void firstDigit_eight() {
        assertThat(underTest.firstDigit("eight")).isEqualTo(8);
    }


    @Test
    void firstDigit_nine() {
        assertThat(underTest.firstDigit("nine")).isEqualTo(9);
    }

    @Test
    void firstDigit_threeAtStart() {
        assertThat(underTest.firstDigit("threeone2")).isEqualTo(3);
    }

    @Test
    void firstDigit_threeInMiddle() {
        assertThat(underTest.firstDigit("abcdethreeone2")).isEqualTo(3);
    }

    @Test
    void firstDigit_threeAtEnd() {
        assertThat(underTest.firstDigit("abcdethree")).isEqualTo(3);
    }

    @Test
    void lastDigit_empty() {
        assertThat(underTest.lastDigit("")).isEqualTo(0);
    }

    @Test
    void lastDigit_noDigits() {
        assertThat(underTest.firstDigit("abcdefh")).isEqualTo(0);
    }

    @Test
    void lastDigit_0() {
        assertThat(underTest.lastDigit("0")).isEqualTo(0);
    }

    @Test
    void lastDigit_1() {
        assertThat(underTest.lastDigit("1")).isEqualTo(1);
    }

    @Test
    void lastDigit_2() {
        assertThat(underTest.lastDigit("2")).isEqualTo(2);
    }

    @Test
    void lastDigit_3() {
        assertThat(underTest.lastDigit("3")).isEqualTo(3);
    }

    @Test
    void lastDigit_4() {
        assertThat(underTest.lastDigit("4")).isEqualTo(4);
    }

    @Test
    void lastDigit_5() {
        assertThat(underTest.lastDigit("5")).isEqualTo(5);
    }

    @Test
    void lastDigit_6() {
        assertThat(underTest.lastDigit("6")).isEqualTo(6);
    }

    @Test
    void lastDigit_7() {
        assertThat(underTest.lastDigit("7")).isEqualTo(7);
    }

    @Test
    void lastDigit_8() {
        assertThat(underTest.lastDigit("8")).isEqualTo(8);
    }

    @Test
    void lastDigit_9() {
        assertThat(underTest.lastDigit("9")).isEqualTo(9);
    }

    @Test
    void lastDigit_3AtStart() {
        assertThat(underTest.lastDigit("3flk")).isEqualTo(3);
    }

    @Test
    void lastDigit_3InMiddle() {
        assertThat(underTest.lastDigit("abc3flk")).isEqualTo(3);
    }

    @Test
    void lastDigit_3AtEnd() {
        assertThat(underTest.lastDigit("abc3")).isEqualTo(3);
    }

    @Test
    void lastDigit_zero() {
        assertThat(underTest.lastDigit("zero")).isEqualTo(0);
    }

    @Test
    void lastDigit_one() {
        assertThat(underTest.lastDigit("one")).isEqualTo(1);
    }

    @Test
    void lastDigit_two() {
        assertThat(underTest.lastDigit("two")).isEqualTo(2);
    }

    @Test
    void lastDigit_three() {
        assertThat(underTest.lastDigit("three")).isEqualTo(3);
    }

    @Test
    void lastDigit_four() {
        assertThat(underTest.lastDigit("four")).isEqualTo(4);
    }

    @Test
    void lastDigit_five() {
        assertThat(underTest.lastDigit("five")).isEqualTo(5);
    }


    @Test
    void lastDigit_six() {
        assertThat(underTest.lastDigit("six")).isEqualTo(6);
    }


    @Test
    void lastDigit_seven() {
        assertThat(underTest.lastDigit("seven")).isEqualTo(7);
    }

    @Test
    void lastDigit_eight() {
        assertThat(underTest.lastDigit("eight")).isEqualTo(8);
    }


    @Test
    void lastDigit_nine() {
        assertThat(underTest.lastDigit("nine")).isEqualTo(9);
    }

    @Test
    void lastDigit_threeAtStart() {
        assertThat(underTest.lastDigit("threeabcd")).isEqualTo(3);
    }

    @Test
    void lastDigit_threeInMiddle() {
        assertThat(underTest.lastDigit("abcdethreeabc")).isEqualTo(3);
    }

    @Test
    void lastDigit_threeAtEnd() {
        assertThat(underTest.lastDigit("abcdethree")).isEqualTo(3);
    }
}