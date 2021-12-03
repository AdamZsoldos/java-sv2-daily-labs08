package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private FileReader() {
        throw new IllegalStateException("Utility class");
    }

    public static int findSmallestTemperatureSpread(Path path) {
        List<String> lines = readFile(path);
        int minSpread = Integer.MAX_VALUE;
        int minDay = -1;
        for (String line : lines) {
            List<String> tokens = getTokens(line);
            if (areTokensNumeric(tokens, 0, 1, 2)) {
                int spread = Integer.parseInt(tokens.get(1)) - Integer.parseInt(tokens.get(2));
                if (spread < minSpread) {
                    minSpread = spread;
                    minDay = Integer.parseInt(tokens.get(0));
                }
            }
        }
        return minDay;
    }

    public static String findSmallestTeamDifference(Path path) {
        List<String> lines = readFile(path);
        int minDifference = Integer.MAX_VALUE;
        String teamName = "";
        for (String line : lines) {
            List<String> tokens = getTokens(line);
            if (areTokensNumeric(tokens, 6, 8)) {
                int difference = Math.abs(Integer.parseInt(tokens.get(8)) - Integer.parseInt(tokens.get(6)));
                if (difference < minDifference) {
                    minDifference = difference;
                    teamName = tokens.get(1);
                }
            }
        }
        return teamName;
    }

    private static List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }

    private static List<String> getTokens(String source) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = null;
        for (int i = 0; i <= source.length(); i++) {
            if (isTokenCharacter(source, i)) {
                if (currentToken == null) currentToken = new StringBuilder();
                currentToken.append(source.charAt(i));
            } else if (currentToken != null) {
                tokens.add(currentToken.toString());
                currentToken = null;
            }
        }
        return tokens;
    }

    private static boolean isTokenCharacter(String source, int index) {
        if (index >= source.length()) return false;
        if (Character.isWhitespace(source.charAt(index))) return false;
        if (source.charAt(index) == '*') return false;
        return true;
    }

    private static boolean areTokensNumeric(List<String> tokens, int... indices) {
        try {
            for (int index : indices) {
                if (index >= tokens.size()) return false;
                Integer.parseInt(tokens.get(index));
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
