package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    NumberSequence ns = new NumberSequence(50, 10, 80);

    @Test
    void testCreate() {
        assertEquals(50, ns.getNumbers().size());
        for (int number : ns.getNumbers()) {
            assertTrue(number >= 10 && number <= 80);
        }
    }

    @Test
    void testGetAverage() {
        double average = ns.getAverage();
        int sum = 0;
        for (int number : ns.getNumbers()) {
            sum += number;
        }
        assertEquals((double) sum / 50, average, 0.05);
    }

    @Test
    void testGetCloseToAverage() {
        double average = ns.getAverage();
        for (int number : ns.getCloseToAverage(20)) {
            assertTrue(Math.abs(number - average) <= 20);
        }
    }
}
