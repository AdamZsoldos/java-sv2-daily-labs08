package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void testFindSmallestTemperatureSpread() {
        assertEquals(14, new FileReader().findSmallestTemperatureSpread(Path.of("src/test/resources/weather.dat")));
    }

    @Test
    void testFindSmallestTeamDifference() {
        assertEquals("Aston_Villa", new FileReader().findSmallestTeamDifference(Path.of("src/test/resources/football.dat")));
    }
}
